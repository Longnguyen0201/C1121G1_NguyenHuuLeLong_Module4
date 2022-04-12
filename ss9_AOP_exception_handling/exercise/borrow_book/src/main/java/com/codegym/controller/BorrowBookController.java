package com.codegym.controller;

import com.codegym.dto.BorrowCardDto;
import com.codegym.model.Book;
import com.codegym.model.BorrowCard;
import com.codegym.model.Borrower;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BorrowBookController {

    @Autowired
    IBookService iBookService;

    @Autowired
    IBorrowCardService iBorrowCardService;

    @GetMapping(value = "/home")
    public ModelAndView showHome(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listBook");
        Page<Book> sachPage = iBookService.findAllBook(pageable);
        modelAndView.addObject("bookPages", sachPage);
        return modelAndView;
    }

    @GetMapping(value = "/create/{bookId}")
    public ModelAndView formCreate(@PathVariable Integer bookId) {
        Optional<Book> book = iBookService.findById(bookId);
        BorrowCardDto borrowCardDto = new BorrowCardDto();
        borrowCardDto.setBook(book.orElse(null));
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("borrowBook");
            modelAndView.addObject("borrowCardDto", borrowCardDto);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/create")
    public ModelAndView create(@Valid @ModelAttribute("borrowCardDto") BorrowCardDto borrowCardDto,
                               BindingResult bindingResult) {
        if (borrowCardDto.getBook().getQuantity() != 0) {
            ModelAndView modelAndView = new ModelAndView("/notice-borrow");
            int id = (int) (Math.random() * 100000 + 1);
            borrowCardDto.setBorrowBookId(String.valueOf(id));
            borrowCardDto.setStatus("Đang mượn");
            if (bindingResult.hasFieldErrors()) {
                modelAndView.addObject("borrowCardDto", borrowCardDto);
                return new ModelAndView("/borrowBook");
            }
            Book book = new Book(borrowCardDto.getBook().getBookId(),
                    borrowCardDto.getBook().getNameBook(),
                    borrowCardDto.getBook().getAuthor(),
                    borrowCardDto.getBook().getQuantity() - 1,
                    borrowCardDto.getBook().getDescribe());
            Borrower borrower = new Borrower(borrowCardDto.getBorrower().getBorrowerId(), borrowCardDto.getBorrower().getName());
            BorrowCard borrowCard = new BorrowCard();
            BeanUtils.copyProperties(borrowCardDto, borrowCard);

            borrowCard.setBook(book);
            borrowCard.setBorrower(borrower);
            iBookService.save(book);
            iBorrowCardService.save(borrowCard);
            modelAndView.addObject("borrowCardID", borrowCard.getBorrowBookId());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/notice-borrow");
            modelAndView.addObject("message", "Sách đã hết không thể mượn");
            return modelAndView;
        }
    }

    @GetMapping(value = "return")
    public ModelAndView giveBook() {
        ModelAndView modelAndView = new ModelAndView("/returnBook");
        return modelAndView;
    }

    @PostMapping(value = "/returnBook")
    public ModelAndView returnBook(@RequestParam("borrowCardId") String borrowCardId) {
        ModelAndView modelAndView;
        BorrowCard borrowCard = iBorrowCardService.findById(borrowCardId);
        if (borrowCard != null) {
            modelAndView = new ModelAndView("redirect:/home");
            borrowCard.setStatus("Đã trả");
            iBorrowCardService.save(borrowCard);
            Book book = new Book(borrowCard.getBook().getBookId(),
                    borrowCard.getBook().getNameBook(),
                    borrowCard.getBook().getAuthor(),
                    borrowCard.getBook().getQuantity() + 1,
                    borrowCard.getBook().getDescribe());
            iBookService.save(book);
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("redirect:/return");
            modelAndView.addObject("message", "Mã mượn sách không tồn tại");
            return modelAndView;
        }
    }

    @GetMapping(value = "/borrowBook")
    public ModelAndView listBorrow(@PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listBorrowBook");
        Page<BorrowCard> borrowCards = iBorrowCardService.findAll(pageable);
        modelAndView.addObject("borrowCards", borrowCards);
        return modelAndView;
    }


}

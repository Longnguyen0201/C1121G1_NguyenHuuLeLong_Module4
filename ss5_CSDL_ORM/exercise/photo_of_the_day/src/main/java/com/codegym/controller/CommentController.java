package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class CommentController {

   @Autowired
    ICommentService iCommentService;

   @GetMapping(value = {"/photo",""})
    public ModelAndView showPicture(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("comment",new Comment());
       List<Comment> commentList = iCommentService.findAll();
        modelAndView.addObject("commentObject",commentList);
        return modelAndView;
   }
   @PostMapping(value = "/create")
    public ModelAndView addComment(@ModelAttribute("comment") Comment comment){
       ModelAndView modelAndView = new ModelAndView("redirect:/photo");
       comment.setNumberLike(0);
       iCommentService.save(comment);
       return modelAndView;
   }
   @GetMapping(value="/like/{id}")
    public ModelAndView likeComment(@PathVariable Integer id){
       ModelAndView modelAndView = new ModelAndView("redirect:/photo");
        Comment comment = iCommentService.findById(id);
        iCommentService.save(comment);

        return modelAndView;
   }

}

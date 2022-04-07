package com.codegym.controller;


import com.codegym.Service.ISongService;
import com.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping(value = {"/song", ""})
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("songList");
        List<Song> songList = iSongService.findAll();
        modelAndView.addObject("songLists", songList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("createSong");
        modelAndView.addObject("songObject", new Song());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    private ModelAndView saveProduct(@ModelAttribute("songObject") Song song) {
        ModelAndView modelAndView = new ModelAndView("redirect:/song");
        iSongService.save(song);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Song song = iSongService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("songObject", song);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editSong(@ModelAttribute("songObject") Song song) {
        ModelAndView modelAndView = new ModelAndView("redirect:/song");
        iSongService.save(song);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteSong(@PathVariable Integer id) {
        Song song = iSongService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("songObject", song);
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute("songObject") Song song) {
        ModelAndView modelAndView = new ModelAndView("redirect:/song");
        iSongService.remove(song.getId());
        return modelAndView;
    }

}

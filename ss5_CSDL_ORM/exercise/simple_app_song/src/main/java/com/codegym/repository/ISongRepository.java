package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    Song findById(Integer id);

    void save(Song song);

    void remove(Integer id);
}

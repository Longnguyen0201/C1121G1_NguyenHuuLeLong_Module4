package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SongRepository implements ISongRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        String queryStr = "SELECT s FROM Song s ";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Integer id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Song.class, id);
    }

    @Override
    public void save(Song song) {
        if (song.getId() != null) {
            entityManager.merge(song);
        } else {
            entityManager.persist(song);
        }

    }

    @Override
    public void remove(Integer id) {
        Song song = findById(id);
        if (song != null){
            entityManager.remove(song);
        }
    }

}

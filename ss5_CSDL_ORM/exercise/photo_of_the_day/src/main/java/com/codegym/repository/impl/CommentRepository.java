package com.codegym.repository.impl;

import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CommentRepository implements ICommentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        String query = "SELECT c from Comment c ";
        TypedQuery<Comment> typedQuery = entityManager.createQuery(query, Comment.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            comment.setNumberLike(comment.getNumberLike() + 1);
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }
    }

    @Override
    public Comment findById(Integer id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Comment.class, id);
    }

}

package com.codegym.repository;

import com.codegym.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {

}

package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer vote;
    private String author;
    private String feedback;
    @Column(name = "number_like")
    private Integer numberLike;
    @Column(name = "date_comment", columnDefinition = "date")
    private String dateComment;

    public Comment() {
    }

    public Comment(Integer vote, String author, String feedback, Integer numberLike, String dateComment) {
        this.vote = vote;
        this.author = author;
        this.feedback = feedback;
        this.numberLike = numberLike;
        this.dateComment = dateComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(Integer numberLike) {
        this.numberLike = numberLike;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }
}

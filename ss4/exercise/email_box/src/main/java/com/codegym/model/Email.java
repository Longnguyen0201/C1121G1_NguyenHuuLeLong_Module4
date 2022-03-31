package com.codegym.model;

public class Email {
    private String language;
    private Integer page_size;
    private Boolean spams_filter;
    private String signature;

    public Email() {
    }

    public Email(String language, Integer page_size, Boolean spams_filter, String signature) {
        this.language = language;
        this.page_size = page_size;
        this.spams_filter = spams_filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Boolean getSpams_filter() {
        return spams_filter;
    }

    public void setSpams_filter(boolean spams_filter) {
        this.spams_filter = spams_filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

package com.bfs.logindemo.domain;

import java.util.Date;

public class Book {
    private Integer isbn;
    private String name;
    private String author;
    private Date publishDate;

    public Book()
    {}
    public Book(Integer isbn, String name,String author,Date publish){
        this.setIsbn(isbn);
        this.setName(name);
        this.setAuthor(author);
        this.setPublishDate(publish);
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

package com.bfs.logindemo.service;

import com.bfs.logindemo.domain.Book;

import java.util.List;

public interface BookService {

    public int add(Book book);

    public List<Book> findAll();

    public int update(Book bookToUpdate);
}

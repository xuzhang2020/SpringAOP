package com.bfs.logindemo.service.impl;

import com.bfs.logindemo.dao.BookDAO;
import com.bfs.logindemo.domain.Book;
import com.bfs.logindemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDao;

    @Override
    public int add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public int update(Book bookToUpdate) {
        return bookDao.update(bookToUpdate);
    }
}

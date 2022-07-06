package com.bfs.logindemo.dao;

import com.bfs.logindemo.domain.Book;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository("myBookDAO")
public class BookDAO {
    private static List<Book> bookList = null;

    static {
        bookList = new ArrayList<>();
        bookList.add(new Book(1,"Book1","Lily",new Date()));
        bookList.add(new Book(2,"Book2","Jim",new Date()));
        bookList.add(new Book(3,"Book3","Tim",new Date()));
        bookList.add(new Book(4,"Book4","Jack",new Date()));
        bookList.add(new Book(5,"Book5","Lucy",new Date()));
    }

    public int add(Book book){
        List<Book> books = bookList.stream().filter(o->o.getIsbn().equals(book.getIsbn())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(books)){
            return 0;
        } else {
            bookList.add(book);
            return 1;
        }
    }

    public List<Book> findAll(){
        return bookList;
    }

    public int update(Book bookToUpdate){
        for(Book book : bookList){
            if(book.getIsbn().equals(bookToUpdate.getIsbn())){
                book.setName(bookToUpdate.getName());
                book.setAuthor(bookToUpdate.getAuthor());
                book.setPublishDate(bookToUpdate.getPublishDate());
                return 1;
            }
        }
        return 0;
    }
}

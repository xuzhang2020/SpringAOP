package com.bfs.logindemo.controller;

import com.bfs.logindemo.controller.vo.BookVo;
import com.bfs.logindemo.domain.Book;
import com.bfs.logindemo.service.BookService;
import com.bfs.logindemo.tools.ResponseInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BookPostController {

    @Autowired
    BookService bookService;

    @GetMapping("posts/book")
    public List<Book> getAllBook(Model model, HttpServletRequest request) {
        List<Book> postBooks = bookService.findAll();

        return postBooks;
    }

    @PostMapping (value = "posts/book")
    public List<Book> Add(@RequestBody BookVo bookVo, Model model) {
        Book book = new Book();
        BeanUtils.copyProperties(bookVo,book);
        int result = bookService.add(book);

        List<Book> books = bookService.findAll();
        return books;
    }


    @PostMapping(value = "posts/book/{id}")
    public ResponseInfo<String> Add(@PathVariable("id") Integer isbn, @RequestBody Book book) {
        ResponseInfo<String> responseInfo = new ResponseInfo<>();
        book.setIsbn(isbn);
        int result = bookService.update(book);
        if(result == 1){
            responseInfo.setCode(ResponseInfo.OK);
            responseInfo.setMessage("Book updated.");
        } else {
            responseInfo.setCode(ResponseInfo.ERROR);
            responseInfo.setMessage("Failed to update the book!");
        }
        return responseInfo;
    }
}

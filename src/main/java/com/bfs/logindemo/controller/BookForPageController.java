package com.bfs.logindemo.controller;

import com.bfs.logindemo.controller.vo.BookVo;
import com.bfs.logindemo.domain.Book;
import com.bfs.logindemo.tools.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookForPageController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/book")
    public String getAllBook(Model model, HttpServletRequest request) {
        ResponseEntity<Book[]> response = restTemplate
                .exchange("http://localhost:8084/posts/book",
                        HttpMethod.GET,null,Book[].class);
        List<Book> books = Arrays.asList(response.getBody())
                .stream()
                .collect(Collectors.toList());
        model.addAttribute("books", books);
        return "book";
    }


    @PostMapping(value = "/book")
    public String Add(BookVo bookVo, Model model) {

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<BookVo> requestEntities = new HttpEntity<BookVo>(bookVo, headers);
        ResponseEntity<Book[]> response = restTemplate
                .exchange("http://localhost:8084/posts/book",
                        HttpMethod.POST,requestEntities,Book[].class);

        List<Book> books = Arrays.asList(response.getBody())
                .stream()
                .collect(Collectors.toList());
        model.addAttribute("books", books);
        return "book";
    }


    @PostMapping(value = "/book/{id}")
    @ResponseBody
    public String Add(@PathVariable("id") Integer isbn, @RequestBody BookVo bookVo) {
        ResponseInfo<String> responseInfo = new ResponseInfo<>();

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<BookVo> requestEntities = new HttpEntity<BookVo>(bookVo, headers);
        ResponseEntity<String> response = restTemplate
                .exchange("http://localhost:8084/posts/book/"+isbn,
                        HttpMethod.POST,requestEntities,String.class);


        return response.getBody();
    }
}

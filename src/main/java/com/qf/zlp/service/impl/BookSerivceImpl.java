package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.BookMapper;
import com.qf.zlp.model.Book;
import com.qf.zlp.model.Books;
import com.qf.zlp.service.BookService;
import com.qf.zlp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookSerivceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserService userService;

    @Override
    public int UpdateBook(Book book) {
        return bookMapper.UpdateBook(book);
    }

    @Override
    public List<Books> likeBooks(String name) {
        return bookMapper.likeBooks(name);
    }



    @Override
    public Book selectBookname(Book book) {
        System.out.println(book);
        return bookMapper.selectBookname(book);
    }


    @Override
    public int AddBook(Book book) {
        return bookMapper.AddBook(book);
    }

    @Override
    public Book BookName(String bname) {

        return bookMapper.BookName(bname);
    }

    @Override
    public int deleteBook(Integer bid) {
        return bookMapper.deleteBook(bid);
    }


}

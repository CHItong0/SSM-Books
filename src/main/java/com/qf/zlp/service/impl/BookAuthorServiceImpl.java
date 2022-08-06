package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.BookAuthorMapper;
import com.qf.zlp.model.BookAuthor;
import com.qf.zlp.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookAuthorServiceImpl implements BookAuthorService {

    @Autowired
    BookAuthorMapper bookAuthorMapper;

    @Override
    public BookAuthor selectBookAutor(Integer bid) {
        return bookAuthorMapper.selectBookAutor(bid);
    }

    @Override
    public int UpdateBookAutor(BookAuthor bookAuthor) {
        return bookAuthorMapper.UpdateBookAutor(bookAuthor);
    }


    @Override
    public int AdddBookAutoraid(BookAuthor bookAuthor) {
        return bookAuthorMapper.AdddBookAutoraid(bookAuthor);
    }

    @Override
    public int deleteBookAutoraid(Integer bid) {
        return bookAuthorMapper.deleteBookAutoraid(bid);
    }


}

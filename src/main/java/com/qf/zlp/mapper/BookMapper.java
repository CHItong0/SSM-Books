package com.qf.zlp.mapper;

import com.qf.zlp.model.Book;
import com.qf.zlp.model.Books;

import java.util.List;

public interface BookMapper {

    int UpdateBook(Book book);

    List<Books> likeBooks(String name);

    Book selectBookname(Book book);

    int AddBook(Book book);

    int deleteBook(Integer bid);

    Book BookName(String bname);









}

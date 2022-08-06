package com.qf.zlp.service;

import com.qf.zlp.model.Book;
import com.qf.zlp.model.Books;


import java.util.List;

public interface BookService {

    int UpdateBook(Book book);

    List<Books> likeBooks(String name);





    Book selectBookname(Book book);


    int AddBook(Book book);


    Book BookName(String bname);

    int deleteBook(Integer bid);
}

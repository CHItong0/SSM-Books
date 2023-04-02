package com.qf.zlp.service;

import com.qf.zlp.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {

    List<BookAuthor> selectBookAutor(Integer bid);

    int UpdateBookAutor(BookAuthor bookAuthor);

    int AdddBookAutoraid(BookAuthor bookAuthor);
}

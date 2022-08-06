package com.qf.zlp.service;

import com.qf.zlp.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {

   BookAuthor selectBookAutor(Integer bid);

    int UpdateBookAutor(BookAuthor bookAuthor);

    int AdddBookAutoraid(BookAuthor bookAuthor);

    int deleteBookAutoraid(Integer bid);
}

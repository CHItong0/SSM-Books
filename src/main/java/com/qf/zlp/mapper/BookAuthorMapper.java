package com.qf.zlp.mapper;

import com.qf.zlp.model.BookAuthor;

import java.util.List;

public interface BookAuthorMapper {

    List<BookAuthor> selectBookAutor(Integer bid);

    int UpdateBookAutor(BookAuthor bookAuthor);

    int AdddBookAutoraid(BookAuthor bookAuthor);


}

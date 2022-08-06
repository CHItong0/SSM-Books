package com.qf.zlp.mapper;

import com.qf.zlp.model.BookAuthor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookAuthorMapper {

    BookAuthor selectBookAutor(Integer bid);

    int UpdateBookAutor(BookAuthor bookAuthor);

    int AdddBookAutoraid(BookAuthor bookAuthor);

    int deleteBookAutoraid(Integer bid);




}

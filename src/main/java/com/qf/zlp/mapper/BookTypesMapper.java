package com.qf.zlp.mapper;

import com.qf.zlp.model.BookAuthor;
import com.qf.zlp.model.BookTypes;

import java.util.List;

public interface BookTypesMapper {


    BookTypes AllBookTypes( Integer bid);

    int UpDateBookType(BookTypes bookTypes);

    int AddBookTypes(BookTypes bookTypes);

    int deleteBookTypes(Integer bid);
}

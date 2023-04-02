package com.qf.zlp.mapper;

import com.qf.zlp.model.BookTypes;

import java.util.List;

public interface BookTypesMapper {


    List<BookTypes> AllBookTypes();

    int UpDateBookType(BookTypes bookTypes);

    BookTypes AddBookTypes(BookTypes bookTypes);
}

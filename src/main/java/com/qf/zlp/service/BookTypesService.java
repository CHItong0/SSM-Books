package com.qf.zlp.service;

import com.qf.zlp.model.BookTypes;

import java.util.List;

public interface BookTypesService {


    List<BookTypes> AllBookTypes();

    int UpDateBookType( BookTypes bookTypes);

    BookTypes AddBookTypes(BookTypes bookTypes);
}



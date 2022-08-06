package com.qf.zlp.service;

import com.qf.zlp.model.BookTypes;

import java.util.List;

public interface BookTypesService {


   BookTypes AllBookTypes(Integer bid);

    int UpDateBookType( BookTypes bookTypes);

    int AddBookTypes(BookTypes bookTypes);

    int deleteBookTypes(Integer bid);
}



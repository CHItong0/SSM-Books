package com.qf.zlp.service;

import com.qf.zlp.model.Types;

public interface TypesService {

    Types selectTypes(Types types);

    int UpdateTypes(String tname);



    int AddTypes(Types types);
}

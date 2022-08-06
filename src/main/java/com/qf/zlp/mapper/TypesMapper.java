package com.qf.zlp.mapper;

import com.qf.zlp.model.Types;

public interface TypesMapper {

    Types selectTypes(Types types);
    int UpdateTypes(String tname);

    int AddTypes(Types types);

    int deleteTyoes(Integer tid);

}

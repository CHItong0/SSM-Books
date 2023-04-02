package com.qf.zlp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    /**
     * 书编号
     */
    private Integer bid;

    /**
     * 书名
     */
    private String bname;

    /**
     * 书描述
     */
    private String bdescribe;
}


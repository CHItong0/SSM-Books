package com.qf.zlp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookAuthor {
    /**
     * 中间表id
     */
    private Integer id;

    /**
     * 作者id
     */
    private Integer aid;

    /**
     * 书名
     */
    private Integer bid;
}


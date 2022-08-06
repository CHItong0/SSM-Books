package com.qf.zlp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookTypes {
    /**
     * 类型中间表id
     */
    private Integer id;

    /**
     * 书本id
     */
    private Integer bid;

    /**
     * 类型id
     */
    private Integer tid;
}


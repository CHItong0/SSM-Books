package com.qf.zlp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBook {
    /**
     * 用户与书本中间表
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 书本id
     */
    private Integer bid;
}


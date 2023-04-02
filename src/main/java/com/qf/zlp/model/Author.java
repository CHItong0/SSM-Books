package com.qf.zlp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    /**
     * 作者编号
     */
    private Integer aid;

    /**
     * 作者名
     */
    private String aname;
}


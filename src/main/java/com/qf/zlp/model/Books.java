package com.qf.zlp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    private Integer bid;

    private String bname;

    private String aname;

    private String bdescribe;

    private String tname;
}

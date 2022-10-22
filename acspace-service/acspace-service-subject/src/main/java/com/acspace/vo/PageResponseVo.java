package com.acspace.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseVo<T> {
    private Long total;
    private Long size;
    private Long pages;
    private Long current;
    private Object data;

}

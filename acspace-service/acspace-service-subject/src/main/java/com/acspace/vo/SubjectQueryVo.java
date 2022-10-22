package com.acspace.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SubjectQueryVo {

    /**
     * 题目
     */
    private String heading;

    /**
     * 章节
     */
    private String chapter;

    /**
     * 发布时间
     */
    private List<String>  publishTime;

    /**
     * 课程分类
     */
    private String subject;

    /**
     * 页数
     */
    @NotNull
    private Long page;

    /**
     * 每页数量
     */
    @NotNull
    private Long size;
}

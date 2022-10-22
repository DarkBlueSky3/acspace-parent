package com.acspace.po;

import com.acspace.converter.PublishTimeConverter;
import com.acspace.handler.JsonTypeHandler;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName(autoResultMap = true)
public class Subject {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 题目
     */
    @ExcelProperty("Heading")
    @ColumnWidth(50)
    private String heading;

    /**
     * 选项A
     */
    @ExcelProperty("OptA")
    @ColumnWidth(10)
    @TableField(value = "opt_a")
    private String optA;

    /**
     * 选项B
     */
    @ExcelProperty("OptB")
    @ColumnWidth(10)
    @TableField(value = "opt_b")
    private String optB;

    /**
     * 选项C
     */
    @ExcelProperty("OptC")
    @ColumnWidth(10)
    @TableField(value = "opt_c")
    private String optC;

    /**
     * 选项D
     */
    @ExcelProperty("OptD")
    @ColumnWidth(10)
    @TableField(value = "opt_d")
    private String optD;

    /**
     * 图片URL
     */
    @ExcelProperty("Image")
    @ColumnWidth(20)
    private String image;

    /**
     * 答案
     */
    @ExcelProperty("Answer")
    @ColumnWidth(10)
    private String answer;

    /**
     * 答案解析
     */
    @ExcelProperty("Note")
    @ColumnWidth(50)
    private String note;

    /**
     * 章节名称
     */
    @ExcelProperty("Chapter")
    @ColumnWidth(10)
    private String chapter;

    /**
     * 发布时间
     */
    @ExcelProperty(value = "PublishTime", converter = PublishTimeConverter.class)
    @ColumnWidth(10)
    @TableField(value = "publish_time", typeHandler = JsonTypeHandler.class)
    private List<String> publishTime;

    /**
     * 课程分类
     */
    @ExcelProperty("Subject")
    @ColumnWidth(10)
    private String subject;
}

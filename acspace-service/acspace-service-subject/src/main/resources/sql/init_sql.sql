DROP TABLE IF EXISTS `subject`;
CREATE TABLE subject (
    `id` BIGINT NOT NULL auto_increment comment '题目编号',
    `heading` VARCHAR(255) NOT NULL COMMENT '题目',
    `opt_a` VARCHAR(255) NOT NULL COMMENT '选项A',
    `opt_b` VARCHAR(255) NOT NULL COMMENT '选项B',
    `opt_c` VARCHAR(255) NOT NULL COMMENT '选项C',
    `opt_d` VARCHAR(255) NOT NULL COMMENT '选项D',
    `image` VARCHAR(64) DEFAULT NULL COMMENT '图片URL',
    `answer` VARCHAR(10) NOT NULL COMMENT '答案',
    `note` LONGTEXT DEFAULT NULL COMMENT '答案解析',
    `chapter` VARCHAR(64) NOT NULL COMMENT '章节',
    `publish_time` json NOT NULL COMMENT '发布时间',
    `subject` VARCHAR(64) NOT NULL COMMENT '课程分类',
    PRIMARY KEY (`id`)
)
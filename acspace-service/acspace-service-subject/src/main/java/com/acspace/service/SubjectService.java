package com.acspace.service;

import com.acspace.po.Subject;
import com.acspace.vo.PageResponseVo;
import com.acspace.vo.SubjectQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SubjectService extends IService<Subject> {

    /**
     * 查询题目
     * @param subjectQueryVo
     * @return
     */
    PageResponseVo<Subject> findSubject(SubjectQueryVo subjectQueryVo);

    /**
     * 导入题目
     * @param file
     */
    void importSubject(MultipartFile file);
}

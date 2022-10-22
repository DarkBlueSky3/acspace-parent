package com.acspace.controller;

import com.acspace.po.Subject;
import com.acspace.service.SubjectService;
import com.acspace.vo.PageResponseVo;
import com.acspace.vo.SubjectQueryVo;
import com.acspace.response.ResponseMessage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询题目
     * @param subjectQueryVo
     * @return
     */
    @PostMapping
    public ResponseMessage getSubject(@RequestBody @Valid SubjectQueryVo subjectQueryVo) {
        PageResponseVo<Subject> subjectPageResponseVo = subjectService.findSubject(subjectQueryVo);
        return ResponseMessage.success(subjectPageResponseVo);
    }

    /**
     * 导入题目
     * @param file
     * @return
     */
    @PostMapping("/import")
    public ResponseMessage importSubject(@RequestPart("file") MultipartFile file) {
        subjectService.importSubject(file);
        return ResponseMessage.success(null);
    }

}

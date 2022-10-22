package com.acspace.service.impl;

import com.acspace.mapper.SubjectMapper;
import com.acspace.po.Subject;
import com.acspace.service.SubjectService;
import com.acspace.utils.QueryParamUtil;
import com.acspace.vo.PageResponseVo;
import com.acspace.vo.SubjectQueryVo;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 查询题目
     * @param subjectQueryVo
     * @return
     */
    @Override
    public PageResponseVo<Subject> findSubject(SubjectQueryVo subjectQueryVo) {
        Page<Subject> page = new Page<>(subjectQueryVo.getPage(), subjectQueryVo.getSize());

        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper<>();
        if (subjectQueryVo.getHeading() != null) {
            wrapper.like(Subject::getHeading, subjectQueryVo.getHeading());
        }
        if (subjectQueryVo.getChapter() != null) {
            wrapper.like(Subject::getChapter, subjectQueryVo.getChapter());
        }
        if (subjectQueryVo.getSubject() != null) {
            wrapper.like(Subject::getSubject, subjectQueryVo.getSubject());
        }
        if (subjectQueryVo.getPublishTime() != null) {
            String publishTimeStr = QueryParamUtil.listToString(subjectQueryVo.getPublishTime());
            wrapper.apply("JSON_CONTAINS(JSON_ARRAY(" + publishTimeStr + "), publish_time)");
        }

        Page<Subject> subjectPage = subjectMapper.selectPage(page, wrapper);
        PageResponseVo<Subject> pageResponseVo= new PageResponseVo<>(subjectPage.getTotal(), subjectPage.getSize(), subjectPage.getPages(), subjectPage.getCurrent(), subjectPage.getRecords());

        return pageResponseVo;
    }

    /**
     * 导入题目
     * @param file
     */
    @Override
    public void importSubject(MultipartFile file) {
        try {
            long start = System.currentTimeMillis();
            List<Subject> subjectList = EasyExcel.read(file.getInputStream())
                    .head(Subject.class)
                    .sheet()
                    .doReadSync();
            //todo 导入校验
            Integer column = subjectMapper.insertBatchSomeColumn(subjectList);
            logger.info("成功导入了{}条数据，耗时{}ms", column, System.currentTimeMillis() - start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

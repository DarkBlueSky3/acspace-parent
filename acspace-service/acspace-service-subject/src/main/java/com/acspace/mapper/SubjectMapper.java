package com.acspace.mapper;

import com.acspace.po.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SubjectMapper extends BaseMapper<Subject> {

    List<Subject> findAll();

    int insert(List<Subject> subjectList);

    Integer insertBatchSomeColumn(Collection<Subject> entityList);
}

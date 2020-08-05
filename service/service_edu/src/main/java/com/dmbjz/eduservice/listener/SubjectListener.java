package com.dmbjz.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.eduservice.entity.EduSubject;
import com.dmbjz.eduservice.entity.excel.SubjectData;
import com.dmbjz.eduservice.service.EduSubjectService;
import com.dmbjz.servicebase.exceptionHandler.LightException;

public class SubjectListener extends AnalysisEventListener<SubjectData> {

    public EduSubjectService eduSubjectService;
    public SubjectListener(){}
    public SubjectListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {

        if(subjectData==null){
            throw new LightException(20001,"文件数据为空");
        }

        //判断一级分类是否
        EduSubject existOneSubject = this.exsisOneSubject(eduSubjectService,subjectData.getFirstSubjectName());
        if(existOneSubject==null){
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getFirstSubjectName());
            eduSubjectService.save(existOneSubject);
        }

        //判断二级分类
        String pid = existOneSubject.getId();
        EduSubject existSecondSubject = this.exsisSecondSubject(eduSubjectService,subjectData.getSecondSubjectName(),pid);
        if(existSecondSubject==null){
            existSecondSubject = new EduSubject();
            existSecondSubject.setParentId(pid);
            existSecondSubject.setTitle(subjectData.getSecondSubjectName());
            eduSubjectService.save(existSecondSubject);
        }


    }


    //一级分类不能重复添加
    private EduSubject exsisOneSubject(EduSubjectService eduSubjectService,String name){
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        EduSubject one = eduSubjectService.getOne(queryWrapper);
        return one;
    }

    //二级分类不能重复添加
    private EduSubject exsisSecondSubject(EduSubjectService eduSubjectService,String name,String pid){
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        EduSubject one = eduSubjectService.getOne(queryWrapper);
        return one;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}

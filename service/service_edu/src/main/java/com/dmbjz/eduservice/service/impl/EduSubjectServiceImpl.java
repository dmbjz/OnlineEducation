package com.dmbjz.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.eduservice.entity.EduSubject;
import com.dmbjz.eduservice.entity.excel.SubjectData;
import com.dmbjz.eduservice.entity.subject.OneSubject;
import com.dmbjz.eduservice.entity.subject.TwoSubject;
import com.dmbjz.eduservice.listener.SubjectListener;
import com.dmbjz.eduservice.mapper.EduSubjectMapper;
import com.dmbjz.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-24
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    //添加课程分类
    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {

            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new SubjectListener(eduSubjectService)).sheet().doRead();

        } catch (Exception e) {

        }

    }


    //Tree分类
    @Override
    public List<OneSubject> getAllOneTwoSubject() {

        //查询一节分类
        QueryWrapper<EduSubject> queryOneWrapper = new QueryWrapper<>();
        queryOneWrapper.eq("parent_id","0");
        List<EduSubject> oneSubjects = baseMapper.selectList(queryOneWrapper);

        //查询二级分类
        QueryWrapper<EduSubject> querySecondWrapper = new QueryWrapper<>();
        querySecondWrapper.ne("parent_id","0");
        List<EduSubject> twoSubjects = baseMapper.selectList(querySecondWrapper);

        //创建List集合，通过遍历将EduSubject的值提取封装到前台的OneSubject
        List<OneSubject> finalSubjectlist = new ArrayList<>();

        //遍历一级分类
        for (EduSubject oneSubject : oneSubjects) {

            //将一级分类的id和名称封装到前台的OneSubject
            OneSubject onesub = new OneSubject();
            BeanUtils.copyProperties(oneSubject,onesub);

            //遍历查询的二级分类,父ID等于一级分类就添加到list中
            List<TwoSubject> twolist = new ArrayList<>();
            for (EduSubject twoSubject : twoSubjects) {
                if (twoSubject.getParentId().equals(oneSubject.getId())){
                    TwoSubject tw = new TwoSubject();
                    BeanUtils.copyProperties(twoSubject,tw);
                    twolist.add(tw);
                }
            }
            onesub.setChild(twolist);
            finalSubjectlist.add(onesub);

        }
        return finalSubjectlist;
    }


}

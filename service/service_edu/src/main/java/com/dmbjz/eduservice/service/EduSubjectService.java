package com.dmbjz.eduservice.service;

import com.dmbjz.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmbjz.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-24
 */
public interface EduSubjectService extends IService<EduSubject> {

    //添加课程方法
    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();

}

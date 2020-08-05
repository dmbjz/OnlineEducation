package com.dmbjz.eduservice.controller;

import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.entity.subject.OneSubject;
import com.dmbjz.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-24
 */
@RestController
@RequestMapping("/eduservice/subject")
@Api(description="分类管理")
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @ApiOperation("分类源excel文件上传")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }

    @ApiOperation("获取分类Tree")
    @GetMapping("getAllSubject")
    public R getAllSubject(){
        //一级分类对应多个二级分类，返回一级分类即可
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }


}


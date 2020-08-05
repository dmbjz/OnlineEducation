package com.dmbjz.eduservice.controller.front;

import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.entity.EduCourse;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.service.EduCourseService;
import com.dmbjz.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "前台控制")
@RestController
@RequestMapping("/eduservice/indexfront")
public class IndexFrontController {

    @Autowired
    private EduCourseService eduCourseService;
    @Autowired
    private EduTeacherService eduTeacherService;


    @ApiOperation("前台首页查询")
    @GetMapping("index")
    @Cacheable(value = "branner",key = "'IndexTeacherAndCourseList'")
    public R selectIndex(){

        //查询前8条件热门课程
        List<EduCourse> indexcourse = eduCourseService.selectIndexCourse();
        //查询前4位讲师
        List<EduTeacher> indexTeacher = eduTeacherService.selectIndexTeacher();
        return R.ok().data("eduList",indexcourse).data("teacherList",indexTeacher);

    }


}

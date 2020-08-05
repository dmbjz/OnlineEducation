package com.dmbjz.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.entity.EduCourse;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.service.EduCourseService;
import com.dmbjz.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "讲师前台管理")
@RestController
@RequestMapping("/eduservice/teacherfront")
public class TeacherFrontController {


    @Autowired
    private EduTeacherService teacherService;
    @Autowired
    private EduCourseService courseService;

    @ApiOperation("前台讲师信息查询")
    @GetMapping("getTeacherPage/{index}/{limit}")
    public R teacherPage(@PathVariable("index") Long index,@PathVariable("limit") Long limit){
        Page<EduTeacher> page = new Page<>(index,limit);
        Map<String,Object> map = teacherService.getTeacherPage(page);
        return R.ok().data("map",map);
    }

    @ApiOperation("讲师id查询信息和课程")
    @GetMapping("getTeacherInfo/{id}")
    public R selectById(@PathVariable("id")Long id){
        EduTeacher teacher = teacherService.getById(id);
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",id);
        List<EduCourse> list = courseService.list(queryWrapper);
        return R.ok().data("teacher",teacher).data("courseList",list);
    }


}

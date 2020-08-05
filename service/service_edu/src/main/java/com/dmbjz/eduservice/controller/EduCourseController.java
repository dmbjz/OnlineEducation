package com.dmbjz.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.client.VodInterface;
import com.dmbjz.eduservice.entity.EduCourse;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.entity.vo.CourseInfoVo;
import com.dmbjz.eduservice.entity.vo.CoursePublishVo;
import com.dmbjz.eduservice.entity.vo.CourseQuery;
import com.dmbjz.eduservice.entity.vo.TeacherQuery;
import com.dmbjz.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author dmbjz
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/eduservice/course")
@Api(description = "课程管理")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("/addCourseInfo")
    @ApiOperation("课程添加")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){

        //删除首页的Redis缓存
        redisTemplate.delete("branner::IndexTeacherAndCourseList");
        //返回添加的课程id
        String id = eduCourseService.addcourse(courseInfoVo);
        return R.ok().data("courseId",id);

    }

    @ApiOperation("根据课程id进行查询")
    @GetMapping("getCourseInfo/{courseId}")
    public R selectbyCourseId(@PathVariable("courseId") String courseId){
        CourseInfoVo courseInfoVo =  eduCourseService.getcourseInfo(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    @ApiOperation("根据课程id进行修改")
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        //删除首页的Redis缓存
        redisTemplate.delete("branner::IndexTeacherAndCourseList");
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    @ApiOperation("获得课程确认信息")
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable("id") String id){
        CoursePublishVo coursePublishVo = eduCourseService.publishCourseInfo(id);
        return R.ok().data("publishCourse",coursePublishVo);

    }

    @ApiOperation("最终确认")
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus(1);
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }

    @ApiOperation("首页的全查询")
    @GetMapping("getCourselist")
    public R getCourseList(){
        List<EduCourse> list = eduCourseService.list(null);
        return R.ok().data("list",list);
    }

    @ApiOperation("首页的分页查询")
    @GetMapping("pageCourse/{index}/{limit}")
    public R pageCourseList(@PathVariable("index") Long index, @PathVariable("limit") Long limit){
        //设置分页参数
        Page<EduCourse> page = new Page<>(index, limit);
        //进行分页，返回数量和记录详情
        eduCourseService.page(page, null);
        List<EduCourse> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("分页查询课程信息带条件")
    @PostMapping("pageCourseCondition/{index}/{limit}")
    public R pageCourseListCondition(@PathVariable("index") Long index, @PathVariable("limit") Long limit, @RequestBody(required = false) CourseQuery courseQuery) {

        Page<EduCourse> page = new Page<>(index, limit);
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();

        //获取参数的值
        String begin = courseQuery.getBegin();
        String end = courseQuery.getEnd();
        Integer status = courseQuery.getStatus();
        String title = courseQuery.getTitle();

        /*根据参数进行的动态SQL拼接*/
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_modified", end);
        }
        if (!StringUtils.isEmpty(status)) {
            queryWrapper.eq("status", status);
        }
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }

        //排序
        queryWrapper.orderByDesc("gmt_create");

        //调用方法进行查询,返回数量和记录详情
        eduCourseService.page(page, queryWrapper);
        List<EduCourse> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("首页的删除课程")
    @DeleteMapping("delete/{courseId}")
    public R deleteCourse(@PathVariable("courseId") String courseId){
        //删除首页的Redis缓存
        redisTemplate.delete("branner::IndexTeacherAndCourseList");
        eduCourseService.deleteCourse(courseId);
        return R.ok();
    }

}


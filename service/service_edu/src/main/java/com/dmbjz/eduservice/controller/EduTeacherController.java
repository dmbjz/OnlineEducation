package com.dmbjz.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.entity.vo.TeacherQuery;
import com.dmbjz.eduservice.service.EduTeacherService;
import com.microsoft.schemas.office.office.STInsetMode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author dmbjz
 * @since 2020-07-21
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;


    @ApiOperation(value = "查询所有讲师")
    @GetMapping(path = "findAll")
    public R findAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据ID进行查询")
    @GetMapping("select/{id}")
    public R selectById(@PathVariable("id")Long id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }


    @ApiOperation("分页查询教师信息")
    @GetMapping("pageTeacher/{index}/{limit}")
    public R selectPageTeacher(@PathVariable("index") Long index, @PathVariable("limit") Long limit) {
        //设置分页参数
        Page<EduTeacher> page = new Page<>(index, limit);
        //进行分页，返回数量和记录详情
        eduTeacherService.page(page, null);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }


    @ApiOperation("分页查询教师信息带条件")
    @PostMapping("pageTeacherCondition/{index}/{limit}")
    public R selectPageTeacherCondition(@PathVariable("index") Long index, @PathVariable("limit") Long limit, @RequestBody(required = false)TeacherQuery teacherQuery) {
        Page<EduTeacher> page = new Page<>(index, limit);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        //获取参数的值
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        Integer level = teacherQuery.getLevel();
        String name = teacherQuery.getName();

        /*根据参数进行的动态SQL拼接*/
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_modified", end);
        }
        if (!StringUtils.isEmpty(level)) {
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        //排序
        queryWrapper.orderByDesc("gmt_create");

        //调用方法进行查询,返回数量和记录详情
        eduTeacherService.page(page, queryWrapper);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }


    @ApiOperation(value = "删除指定讲师")
    @DeleteMapping(path = "remove/{id}")
    public R removeTeacher(@PathVariable("id") String id) {
        boolean remove = eduTeacherService.removeById(id);
        if (remove) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R insertTeacher(@RequestBody EduTeacher eduTeacher){
       boolean save = eduTeacherService.save(eduTeacher);
       if (save){
           return R.ok();
       }else {
           return R.error();
       }
    }

    @ApiOperation(value = "根据ID修改讲师信息")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean insert = eduTeacherService.updateById(eduTeacher);
        if (insert){
            return R.ok();
        }else{
            return R.error();
        }
    }

}


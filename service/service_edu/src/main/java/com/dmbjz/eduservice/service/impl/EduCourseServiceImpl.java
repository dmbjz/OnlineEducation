package com.dmbjz.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.eduservice.entity.EduCourse;
import com.dmbjz.eduservice.entity.EduCourseDescription;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.entity.front.CourseFrontVo;
import com.dmbjz.eduservice.entity.front.CourseWebVo;
import com.dmbjz.eduservice.entity.vo.CourseInfoVo;
import com.dmbjz.eduservice.entity.vo.CoursePublishVo;
import com.dmbjz.eduservice.mapper.EduCourseMapper;
import com.dmbjz.eduservice.service.EduChapterService;
import com.dmbjz.eduservice.service.EduCourseDescriptionService;
import com.dmbjz.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmbjz.eduservice.service.EduVideoService;
import com.dmbjz.servicebase.exceptionHandler.LightException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author dmbjz
 * @since 2020-07-25
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;
    @Autowired
    private EduVideoService eduVideoService;
    @Autowired
    private EduChapterService eduChapterService;

    //添加课程
    @Override
    public String addcourse(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert == 0) {
            throw new LightException(20001, "添加课程失败");
        }
        //设置课程简介
        String uid = eduCourse.getId();
        EduCourseDescription description = new EduCourseDescription();
        description.setId(uid);
        description.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.save(description);

        return uid;
    }

    //查询课程
    @Override
    public CourseInfoVo getcourseInfo(String courseId) {

        //查询章节表和小节表
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse, courseInfoVo);

        EduCourseDescription eduDescription = courseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(eduDescription.getDescription());

        return courseInfoVo;
    }

    //修改课程
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {

        EduCourse eduCourse = new EduCourse();
        EduCourseDescription eduDescription = new EduCourseDescription();
        //赋值
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        BeanUtils.copyProperties(courseInfoVo, eduDescription);
        //更新
        int i = baseMapper.updateById(eduCourse);
        boolean b = courseDescriptionService.updateById(eduDescription);
        if (i == 0) {
            throw new LightException(20001, "课程修改失败");
        }
        if (!b) {
            throw new LightException(20001, "描述修改失败");
        }


    }

    @Override
    //查询课程
    public CoursePublishVo publishCourseInfo(String id) {
        //调用XML里的自定义Mapper
        CoursePublishVo coursePublishVo = baseMapper.getublishCourseInfo(id);
        return coursePublishVo;
    }

    //首页的删除课程
    @Override
    public void deleteCourse(String courseId) {

        //删除小节和视频
        eduVideoService.removeVideoByCouseId(courseId);
        //删除章节
        eduChapterService.removeChapterByCouseId(courseId);
        //删除课程描述
        courseDescriptionService.removeById(courseId);
        //删除课程
        int i = baseMapper.deleteById(courseId);
        if (i == 0) {
            throw new LightException(20001, "删除失败");
        }

    }


    /*前台首页的热门课程展示*/
    @Override
    public List<EduCourse> selectIndexCourse() {
        //采用id排序，雪花算法生成的id相等于时间排序
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 8");
        List<EduCourse> list = baseMapper.selectList(queryWrapper);
        return list;
    }


    //前台的课程分页
    @Override
    public Map<String, Object> getCourseFrontList(Page<EduCourse> pageParam, CourseFrontVo courseQuery) {

        QueryWrapper<EduCourse> q = new QueryWrapper<>();

        //一级分类
        if (!StringUtils.isEmpty(courseQuery.getSubjectParentId())){
            q.eq("subject_parent_id",courseQuery.getSubjectParentId());
        }
        //二级分类
        if (!StringUtils.isEmpty(courseQuery.getSubjectId())){
            q.eq("subject_id",courseQuery.getSubjectId());
        }
        //浏览量
        if (!StringUtils.isEmpty(courseQuery.getBuyCountSort())){
            q.orderByDesc("buy_count");
        }
        //创建时间
        if (!StringUtils.isEmpty(courseQuery.getGmtCreateSort())) {
            q.orderByDesc("gmt_create");
        }
        //价格
        if (!StringUtils.isEmpty(courseQuery.getPriceSort())) {
            q.orderByDesc("price");
        }

        baseMapper.selectPage(pageParam,q);

        List<EduCourse> records = pageParam.getRecords();
        long current = pageParam.getCurrent();
        long pages = pageParam.getPages();
        long size = pageParam.getSize();
        long total = pageParam.getTotal();
        boolean hasNext = pageParam.hasNext();
        boolean hasPrevious = pageParam.hasPrevious();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);

        return map;

    }

    @Override
    public CourseWebVo getFrontCourseInfo(String courseId) {
        return baseMapper.getBaseCourseInfo(courseId);
    }


}

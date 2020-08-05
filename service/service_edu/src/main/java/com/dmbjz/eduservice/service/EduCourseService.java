package com.dmbjz.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.entity.front.CourseFrontVo;
import com.dmbjz.eduservice.entity.front.CourseWebVo;
import com.dmbjz.eduservice.entity.vo.CourseInfoVo;
import com.dmbjz.eduservice.entity.vo.CoursePublishVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
public interface EduCourseService extends IService<EduCourse> {

    String addcourse(CourseInfoVo courseInfoVo);

    CourseInfoVo getcourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void deleteCourse(String courseId);

    List<EduCourse> selectIndexCourse();

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageParam, CourseFrontVo courseQuery);

    CourseWebVo getFrontCourseInfo(String courseId);
}

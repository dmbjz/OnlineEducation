package com.dmbjz.eduservice.mapper;

import com.dmbjz.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmbjz.eduservice.entity.front.CourseWebVo;
import com.dmbjz.eduservice.entity.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    public CoursePublishVo getublishCourseInfo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);

}

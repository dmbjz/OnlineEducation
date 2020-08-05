package com.dmbjz.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-21
 */
public interface EduTeacherService extends IService<EduTeacher> {

    List<EduTeacher> selectIndexTeacher();

    Map<String, Object> getTeacherPage(Page<EduTeacher> page);
}

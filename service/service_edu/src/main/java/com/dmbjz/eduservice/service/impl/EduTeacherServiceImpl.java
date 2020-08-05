package com.dmbjz.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.eduservice.entity.EduCourse;
import com.dmbjz.eduservice.entity.EduTeacher;
import com.dmbjz.eduservice.mapper.EduTeacherMapper;
import com.dmbjz.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-21
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    /*后台页面的讲师查询*/
    @Override
    public List<EduTeacher> selectIndexTeacher() {
        //采用id排序，雪花算法生成的id相等于时间排序
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 4");
        List<EduTeacher> list = baseMapper.selectList(queryWrapper);
        return list;
    }

    /*前台查询分页*/
    @Override
    public Map<String, Object> getTeacherPage(Page<EduTeacher> page) {

        QueryWrapper<EduTeacher> q = new QueryWrapper<>();
        q.orderByDesc("sort");
        q.orderByDesc("gmt_create");
        baseMapper.selectPage(page,q);

        List<EduTeacher> records = page.getRecords();
        long current = page.getCurrent();
        long pages = page.getPages();
        long size = page.getSize();
        long total = page.getTotal();
        boolean hasNext = page.hasNext();
        boolean hasPrevious = page.hasPrevious();

        //获取分页数据放入Map中
        Map<String,Object> map = new HashMap<>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);

        return map;

    }

}


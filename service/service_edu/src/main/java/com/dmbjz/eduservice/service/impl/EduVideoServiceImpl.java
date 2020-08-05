package com.dmbjz.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.eduservice.client.VodInterface;
import com.dmbjz.eduservice.entity.EduVideo;
import com.dmbjz.eduservice.mapper.EduVideoMapper;
import com.dmbjz.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Autowired
    private VodInterface vodInterface;

    //删除小节
    @Override
    public void removeVideoByCouseId(String courseId) {

        //查询出所有的视频id
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.select("video_source_id");
        List<EduVideo> list = baseMapper.selectList(wrapper);

        //将EduVideo转换为String
        List<String> strlist = new ArrayList<>();
        for (EduVideo video : list) {
            String sourceId = video.getVideoSourceId();
            if (!StringUtils.isEmpty(sourceId)){
                strlist.add(sourceId);
            }
        }

        //删除视频
        vodInterface.deleteVideoList(strlist);

        //删除小节
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        baseMapper.delete(queryWrapper);

    }


}

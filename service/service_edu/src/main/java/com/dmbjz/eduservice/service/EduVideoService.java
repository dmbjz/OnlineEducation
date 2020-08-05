package com.dmbjz.eduservice.service;

import com.dmbjz.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeVideoByCouseId(String courseId);

}

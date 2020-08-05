package com.dmbjz.eduservice.service;

import com.dmbjz.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmbjz.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCouseId(String courseId);
}

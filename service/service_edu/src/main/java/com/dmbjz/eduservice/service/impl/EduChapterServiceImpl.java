package com.dmbjz.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.eduservice.entity.EduChapter;
import com.dmbjz.eduservice.entity.EduVideo;
import com.dmbjz.eduservice.entity.chapter.ChapterVo;
import com.dmbjz.eduservice.entity.chapter.VideoVo;
import com.dmbjz.eduservice.mapper.EduChapterMapper;
import com.dmbjz.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmbjz.eduservice.service.EduVideoService;
import com.dmbjz.servicebase.exceptionHandler.LightException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;

    //根据课程id查询
    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {

        //根据课程id查询所有章节
        QueryWrapper<EduChapter> chapter = new QueryWrapper<>();
        chapter.eq("course_id",courseId);
        List<EduChapter> list = baseMapper.selectList(chapter);

        //根据课程id查询所有小节
        QueryWrapper<EduVideo> chapterchild = new QueryWrapper<>();
        chapterchild.eq("course_id",courseId);
        List<EduVideo> listchild =  eduVideoService.list(chapterchild);

        //创建课程中章节的list
        List<ChapterVo> chapterVoList = new ArrayList<>();
        //遍历查询章节list进行封装
        for (EduChapter eduChapter : list) {

            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter,chapterVo);

            //创建小节的list
            List<VideoVo> videoVoList = new ArrayList<>();
            //遍历小节
            for (EduVideo eduVideo : listchild) {
                if (eduVideo.getCourseId().equals(eduChapter.getCourseId())&&eduVideo.getChapterId().equals(eduChapter.getId())){
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo,videoVo);
                    videoVoList.add(videoVo);
                }
            }
            //小节塞入章节
            chapterVo.setChild(videoVoList);
            //将章节加入课程章节list
            chapterVoList.add(chapterVo);

        }

        //遍历查询小节list进行封装
        return chapterVoList;
    }

    //删除章节
    @Override
    public boolean deleteChapter(String chapterId) {
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id",chapterId);
        //返还小节记录数
        int i = eduVideoService.count(queryWrapper);
        if (i!=0){
            //拒绝删除
            throw new LightException(20001,"不能删除");
        }else{
            //可以删除
            int delete = baseMapper.deleteById(chapterId);
            //成功就是true，失败就是false
            return delete>0;
        }


    }

    //根据课程ID删除章节
    @Override
    public void removeChapterByCouseId(String courseId) {
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        baseMapper.delete(queryWrapper);
    }

}

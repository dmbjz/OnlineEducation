package com.dmbjz.eduservice.controller;

import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.entity.EduChapter;
import com.dmbjz.eduservice.entity.chapter.ChapterVo;
import com.dmbjz.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/eduservice/chapter")
@Api(description = "章节管理")
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @ApiOperation("根据章节查询小节")
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable("courseId") String courseId){
        List<ChapterVo> list =  eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("allChapterVideo",list);
    }

    @ApiOperation("添加章节")
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.save(eduChapter);
        return R.ok();
    }

    @ApiOperation("根据ID查询")
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId){
        EduChapter byId = eduChapterService.getById(chapterId);
        return R.ok().data("chapter",byId);
    }

    @ApiOperation("修改章节")
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.updateById(eduChapter);
        return R.ok();
    }

    @ApiOperation("删除章节")
    @DeleteMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable("chapterId") String chapterId){
        boolean i = eduChapterService.deleteChapter(chapterId);
        return R.ok();
    }


}


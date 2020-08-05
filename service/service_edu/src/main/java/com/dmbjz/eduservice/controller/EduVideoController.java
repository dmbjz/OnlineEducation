package com.dmbjz.eduservice.controller;


import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.client.VodInterface;
import com.dmbjz.eduservice.entity.EduVideo;
import com.dmbjz.eduservice.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author dmbjz
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/eduservice/video")
@Api(description = "课程视频管理")
public class EduVideoController {


    @Autowired
    private EduVideoService eduVideoService;
    @Autowired
    private VodInterface vodInterface;

    @ApiOperation("查询小节")
    @GetMapping("/selectVideo/{id}")
    public R selectVideo(@PathVariable("id") String id){
        EduVideo video = eduVideoService.getById(id);
        return R.ok().data("list",video);
    }

    @ApiOperation("添加小节")
    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    @ApiOperation("删除小节")
    @DeleteMapping("/deleteVideo/{id}")
    public R deleteVideo(@PathVariable("id") String id){
        //根据小节ID查询对应的视频ID
        EduVideo eduVideo = eduVideoService.getById(id);
        String aliVideoId = eduVideo.getVideoSourceId();
        //调用SpringCloud注册的vod远程方法，删除小节上传到阿里云的视频
        if (!StringUtils.isEmpty(aliVideoId)){
            vodInterface.deleteVideo(aliVideoId);
        }
        eduVideoService.removeById(id);
        return R.ok();
    }

    @ApiOperation("更新章节")
    @PostMapping("/updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.updateById(eduVideo);
        return R.ok();
    }


}


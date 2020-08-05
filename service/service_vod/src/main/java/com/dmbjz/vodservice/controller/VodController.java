package com.dmbjz.vodservice.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.dmbjz.commonutils.R;
import com.dmbjz.vodservice.service.VodService;
import com.dmbjz.vodservice.utils.ConstantVodutils;
import com.dmbjz.vodservice.utils.InitVodClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("eduvod/video")
@Api(description = "阿里云视频服务")
public class VodController {

    @Autowired
    private VodService vodService;

    @ApiOperation("小节视频上传")
    @PostMapping("/uploadAliVideo")
    public R uploadVideo(MultipartFile file) {
        String id = vodService.uploadVideo(file);
        return R.ok().data("videoId",id);
    }

    @ApiOperation("小节视频删除")
    @DeleteMapping("/deleteVideo/{id}")
    public R deleteVideo(@PathVariable("id") String videoId) {
        vodService.deleteVideo(videoId);
        return R.ok();
    }

    @ApiOperation("课程删除时的小节视频删除")
    @DeleteMapping("/deletebatch")
    public R deleteVideoList(@RequestParam("videoIdList") List<String> videoIdList){
        vodService.removeMoreAliyunVideo(videoIdList);
        return R.ok();
    }


    @GetMapping("getPlayVideo/{id}")
    public R getVideo(@PathVariable("id")String id){

        try{

            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodutils.KEY_ID, ConstantVodutils.KEY_SHEET);
            //获取凭证对象
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(id);
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            return R.ok().data("playAuth",playAuth);

        }catch(Exception e){

            return R.error().message("视频解析出错");

        }

    }

}

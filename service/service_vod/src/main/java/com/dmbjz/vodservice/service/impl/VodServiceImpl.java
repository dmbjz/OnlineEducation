package com.dmbjz.vodservice.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.dmbjz.servicebase.exceptionHandler.LightException;
import com.dmbjz.vodservice.service.VodService;
import com.dmbjz.vodservice.utils.ConstantVodutils;
import com.dmbjz.vodservice.utils.InitVodClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
public class VodServiceImpl implements VodService {

    /*视频上传*/
    @Override
    public String uploadVideo(MultipartFile file) {

        try {
            //获取文件原始名称
            String fileName = file.getOriginalFilename();
            //设置上传后的名称
            String title = file.getOriginalFilename().substring(0,fileName.lastIndexOf("."));
            InputStream inputStream = file.getInputStream();

            UploadStreamRequest request = new UploadStreamRequest(ConstantVodutils.KEY_ID, ConstantVodutils.KEY_SHEET, title,fileName,inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            String videoId = null;
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                videoId = response.getVideoId();
            }
            return videoId;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    /*视频删除*/
    @Override
    public void deleteVideo(String videoId) {

        try{
            //设置keyid和keysheet
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodutils.KEY_ID, ConstantVodutils.KEY_SHEET);
            //创建删除请求
            DeleteVideoRequest request = new DeleteVideoRequest();
            //设置视频ID
            request.setVideoIds(videoId);
            //实现删除
            client.getAcsResponse(request);
        }catch (Exception e){
            throw new LightException(20001, "视频删除失败");
        }

    }

    @Override
    public void removeMoreAliyunVideo(List videoIdList) {

        try{
            //设置keyid和keysheet
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodutils.KEY_ID, ConstantVodutils.KEY_SHEET);
            //创建删除请求
            DeleteVideoRequest request = new DeleteVideoRequest();
            //设置视频ID
            String videoIds = StringUtils.join(videoIdList.toArray(), ",");
            request.setVideoIds(videoIds);
            //实现删除
            client.getAcsResponse(request);
        }catch (Exception e){
            throw new LightException(20001, "视频删除失败");
        }

    }

}

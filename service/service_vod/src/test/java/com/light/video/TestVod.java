package com.light.video;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

import java.util.List;

public class TestVod {


    public static void main(String[] args) throws Exception {

        String accessKsyId = "LTAI4GFzrZUbxJoigBhEustA";
        String accessKsySecret = "kvJ2EEdcplRwwNRsFR0bpQDOonWZnl";
        String title = "hello";//上传视频显示的名称
        String fileName = "D:\\AliYunTestVideo\\dmbjz.mp4";//视频地址

        UploadVideoRequest request = new UploadVideoRequest(accessKsyId, accessKsySecret,title,fileName);
        /* 可指定分片上传时每个分片的大小，默认为2M字节 */
        request.setPartSize(2 * 1024 * 1024L);
        /* 可指定分片上传时的并发线程数，默认为1，(注：该配置会占用服务器CPU资源，需根据服务器情况指定）*/
        request.setTaskNum(1);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);

        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }


    //获得视频播放地址
    public static void getPlayUrl() throws Exception {

        DefaultAcsClient client = InitObject.initVodClient("LTAI4GFzrZUbxJoigBhEustA", "kvJ2EEdcplRwwNRsFR0bpQDOonWZnl");
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        GetPlayInfoRequest request = new GetPlayInfoRequest();

        request.setVideoId("3b817eac3f174603bc29030a553fc82c");

        response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
    }

    //获得视频播放凭证
    public static void getPlayAuth() throws ClientException {
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GFzrZUbxJoigBhEustA", "kvJ2EEdcplRwwNRsFR0bpQDOonWZnl");
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        request.setVideoId("3b817eac3f174603bc29030a553fc82c");
        response = client.getAcsResponse(request);
        System.out.println("playAuthor：" + response.getPlayAuth());
    }

}

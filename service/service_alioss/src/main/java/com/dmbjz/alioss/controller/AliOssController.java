package com.dmbjz.alioss.controller;

import com.dmbjz.alioss.service.AliOssService;
import com.dmbjz.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@Api(description = "阿里云oss服务")
public class AliOssController {

    @Autowired
    private AliOssService ossService;

    //上传头像到oss
    @ApiOperation(value ="文件上传")
    @PostMapping("/upload")
    public R uploadOssFile(MultipartFile file){
        //返回上传的路径
        String url = ossService.uploadFile(file);
        return R.ok().data("url",url);
    }

}

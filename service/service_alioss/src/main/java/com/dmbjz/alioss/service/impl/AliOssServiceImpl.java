package com.dmbjz.alioss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.dmbjz.alioss.service.AliOssService;
import com.dmbjz.alioss.utils.ReadPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Service
public class AliOssServiceImpl implements AliOssService {

    @Override
    public String uploadFile(MultipartFile file){

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ReadPropertiesUtils.END_POINT;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ReadPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ReadPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ReadPropertiesUtils.BUCKET_NAME;

        try {

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();
            //文件an年月日分类
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //解决覆盖问题
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            String fileName = datePath+"/"+uuid+file.getOriginalFilename();
            //Bucket名称，文件路径，输入流
            ossClient.putObject(bucketName, fileName, inputStream);
            //关闭流
            ossClient.shutdown();
            //返回路径
            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}

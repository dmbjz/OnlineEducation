package com.dmbjz.vodservice.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*阿里云视频上传配置*/
@Component
public class ConstantVodutils implements InitializingBean {

    @Value("${aliyun.vod.file.keyid}")
    private String keyId;

    @Value("${aliyun.vod.file.keysecret}")
    private String keySheet;

    //定义公开静态常量
    public static String KEY_ID;
    public static String KEY_SHEET;

    //InitializingBean,Spring注入数据后执行的方法
    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID = keyId;
        KEY_SHEET = keySheet;
    }


}

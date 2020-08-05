package com.dmbjz.eduservice.client;

import com.dmbjz.commonutils.R;
import org.springframework.stereotype.Component;
import java.util.List;

//SpringCloud的OpenFeign兜底方法
@Component
public class VodFileDegradeFeignClient implements VodInterface {

    @Override
    public R deleteVideo(String videoId) {
        return R.error().message("time out");
    }

    @Override
    public R deleteVideoList(List<String> videoIdList) {
        return R.error().message("time out");
    }

}

package com.dmbjz.eduservice.client;

import com.dmbjz.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*SpringCloud服务调用的OpenFeign接口*/
@FeignClient(value = "service-vod",fallback = VodFileDegradeFeignClient.class)
@Component
public interface VodInterface {

    @DeleteMapping("/eduvod/video/deleteVideo/{id}")
    public R deleteVideo(@PathVariable("id") String videoId);

    @DeleteMapping("/eduvod/video/deletebatch")
    public R deleteVideoList(@RequestParam("videoIdList")List<String> videoIdList);

}

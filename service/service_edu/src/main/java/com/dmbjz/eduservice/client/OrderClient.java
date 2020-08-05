package com.dmbjz.eduservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-order",fallback = OrderFeignClientImpl.class)
@Component
public interface OrderClient {

    @GetMapping("/orderservice/order/isBuyCourse/{courseId}/{userId}")
    public boolean isbycourse(@PathVariable("courseId")String courseId, @PathVariable("userId")String userId);

}

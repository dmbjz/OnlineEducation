package com.dmbjz.orderservice.client;

import com.dmbjz.commonutils.order.CourseWebVoOrder;
import com.dmbjz.orderservice.client.fallback.OrderCourseClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-edu",fallback = OrderCourseClientImpl.class)
@Component
public interface OrderCourseClient {

    @GetMapping("/eduservice/coursefront/getCourseInfoOrder/{id}")
    public CourseWebVoOrder getcoursebyId(@PathVariable("id")String id);

}

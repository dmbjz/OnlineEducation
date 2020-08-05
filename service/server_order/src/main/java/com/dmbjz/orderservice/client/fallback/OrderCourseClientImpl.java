package com.dmbjz.orderservice.client.fallback;

import com.dmbjz.commonutils.order.CourseWebVoOrder;
import com.dmbjz.orderservice.client.OrderCourseClient;
import org.springframework.stereotype.Component;


@Component
public class OrderCourseClientImpl implements OrderCourseClient {
    @Override
    public CourseWebVoOrder getcoursebyId(String id) {
        return null;
    }
}

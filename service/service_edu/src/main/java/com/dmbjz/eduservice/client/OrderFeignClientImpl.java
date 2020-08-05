package com.dmbjz.eduservice.client;

import org.springframework.stereotype.Component;

@Component
public class OrderFeignClientImpl implements OrderClient {

    @Override
    public boolean isbycourse(String courseId, String userId) {
        return false;
    }

}

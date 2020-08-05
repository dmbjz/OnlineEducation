package com.dmbjz.eduservice.client;

import com.dmbjz.eduservice.entity.login.UcenterMember;
import org.springframework.stereotype.Component;

@Component
public class UserloginFeignClient implements UcenterClient {
    @Override
    public UcenterMember getInfo(String id) {
        return null;
    }

}

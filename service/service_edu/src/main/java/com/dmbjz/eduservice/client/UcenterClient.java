package com.dmbjz.eduservice.client;

import com.dmbjz.eduservice.entity.login.UcenterMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "service-ucenter",fallback = UserloginFeignClient.class)
@Component
public interface UcenterClient {

    @PostMapping("/educenter/member/getInfoUc/{id}")
    public UcenterMember getInfo(@PathVariable String id);

}

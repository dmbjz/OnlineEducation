package com.dmbjz.usercount.client;

import com.dmbjz.usercount.client.impl.CountDayFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "service-ucenter",fallback = CountDayFallBack.class)
public interface CountDayService {

    @GetMapping("/educenter/member/countRegister/{day}")
    public Integer countRegister(@PathVariable("day")String day);

}

package com.dmbjz.msmservice.controller;

import com.dmbjz.commonutils.R;
import com.dmbjz.msmservice.service.MsmService;
import com.dmbjz.msmservice.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/edumsm")
@Api(description = "阿里云短信服务")
public class MsmController {

    @Autowired
    private MsmService msmService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @ApiOperation("发送短信")
    @GetMapping("/msm/{phone}")
    public R sendMsm(@PathVariable("phone") String phone) {

        String s = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(s)){
            return R.ok();
        }

        String random = RandomUtil.getFourBitRandom();
        Map<String,Object> param = new HashMap<>();
        param.put("code",random);
        //发送短信
        boolean isSedn = msmService.send(param,phone);
        if (isSedn){
            //发送成功，把验证码放入redis,设置五分钟有效时间
            redisTemplate.opsForValue().set(phone,random,5, TimeUnit.MINUTES);
            return R.ok();
        }else{
            return R.error().message("短信发送失败");
        }

    }

}

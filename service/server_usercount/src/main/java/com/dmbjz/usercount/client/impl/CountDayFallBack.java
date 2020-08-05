package com.dmbjz.usercount.client.impl;

import com.dmbjz.usercount.client.CountDayService;
import org.springframework.stereotype.Component;

@Component
public class CountDayFallBack implements CountDayService {

    @Override
    public Integer countRegister(String day) {
        return null;
    }

}

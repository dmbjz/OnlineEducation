package com.dmbjz.usercount.controller;

import com.dmbjz.commonutils.R;
import com.dmbjz.usercount.service.StatisticsDailyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author dmbjz 
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/usercount/daily")
@Api(description = "用户注册统计")
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService dailyService;

    @ApiOperation("获取某天注册人数")
    @GetMapping("registerCount/{day}")
    public R registerCount(@PathVariable("day")String day){
        boolean b = dailyService.registerCount(day);
        if (b){
            return R.ok();
        }else{
            return R.error().message("该日期没有用户注册");
        }
    }

    @ApiOperation("图表显示")
    @GetMapping("showData/{type}/{begin}/{end}")
    public R showData(@PathVariable("type")String type,@PathVariable("begin")String begin,@PathVariable("end")String end){

        Map<String,Object> map = dailyService.getShowData(type,begin,end);
        return R.ok().data(map);

    }

}


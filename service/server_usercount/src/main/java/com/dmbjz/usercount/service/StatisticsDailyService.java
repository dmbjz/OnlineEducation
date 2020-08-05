package com.dmbjz.usercount.service;

import com.dmbjz.usercount.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-08-03
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    boolean registerCount(String day);

    Map<String, Object> getShowData(String type, String begin, String end);
}

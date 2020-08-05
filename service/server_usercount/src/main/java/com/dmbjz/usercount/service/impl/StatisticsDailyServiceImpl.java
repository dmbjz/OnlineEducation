package com.dmbjz.usercount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.usercount.client.CountDayService;
import com.dmbjz.usercount.entity.StatisticsDaily;
import com.dmbjz.usercount.mapper.StatisticsDailyMapper;
import com.dmbjz.usercount.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author dmbjz
 * @since 2020-08-03
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

    @Autowired
    private CountDayService countDayService;

    @Override
    public boolean registerCount(String day) {

        Integer integer = countDayService.countRegister(day);

        if (integer != 0) {
            //删除同一天统计的旧数据
            QueryWrapper<StatisticsDaily> dayQueryWrapper = new QueryWrapper<>();
            dayQueryWrapper.eq("date_calculated", day);
            baseMapper.delete(dayQueryWrapper);

            StatisticsDaily daily = new StatisticsDaily();
            daily.setRegisterNum(integer);//设置人数
            daily.setDateCalculated(day);//设置日期

            daily.setLoginNum(RandomUtils.nextInt(100, 200));
            daily.setVideoViewNum(RandomUtils.nextInt(100, 200));
            daily.setCourseNum(RandomUtils.nextInt(100, 200));

            baseMapper.insert(daily);
            return true;
        }

        return false;


    }

    @Override
    public Map<String, Object> getShowData(String type, String begin, String end) {

        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.between("date_calculated",begin,end);
        wrapper.select("date_calculated",type);
        List<StatisticsDaily> dailyList = baseMapper.selectList(wrapper);

        //返回list，json的数组
        List<String> dateList = new ArrayList<>();
        List<Integer> numDataList = new ArrayList<>();

        for (StatisticsDaily statisticsDaily : dailyList) {
            //封装日期
            dateList.add(statisticsDaily.getDateCalculated());
            //封装数量
            switch (type) {
                case "register_num":
                    numDataList.add(statisticsDaily.getRegisterNum());
                    break;
                case "login_num":
                    numDataList.add(statisticsDaily.getLoginNum());
                    break;
                case "video_view_num":
                    numDataList.add(statisticsDaily.getVideoViewNum());
                    break;
                case "course_num":
                    numDataList.add(statisticsDaily.getCourseNum());
                    break;
                default:
                    break;
            }

        }

        //封装到Map集合中
        Map<String,Object> map = new HashMap<>();
        map.put("dateList",dateList);
        map.put("numDataList",numDataList);
        return map;

    }


}

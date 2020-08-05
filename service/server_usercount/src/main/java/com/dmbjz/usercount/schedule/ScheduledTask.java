package com.dmbjz.usercount.schedule;

import com.dmbjz.usercount.service.StatisticsDailyService;
import com.dmbjz.usercount.utils.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTask {

    private StatisticsDailyService statistics;

    /**
     * 每天凌晨一点执行
     */
    @Scheduled(cron = "0 0 1 * * ? ")
    public void task1() {
        String day = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        statistics.registerCount(day);
    }


}

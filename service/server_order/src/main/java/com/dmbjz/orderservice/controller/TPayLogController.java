package com.dmbjz.orderservice.controller;

import com.dmbjz.commonutils.R;
import com.dmbjz.orderservice.service.TPayLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author dmbjz
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/orderservice/paylog")
public class TPayLogController {

    @Autowired
    private TPayLogService tPayLogService;

    @ApiOperation("微信支付生成二维码")
    @GetMapping("/createNative/{orderNo}")
    public R createNative(@PathVariable("orderNo") String orderNo) {
        Map map = tPayLogService.createNative(orderNo);
        return R.ok().data(map);
    }

    @ApiOperation("根据订单号查询订单状态")
    @GetMapping("/queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo) {
        //调用查询接口
        Map<String, String> map = tPayLogService.queryPayStatus(orderNo);
        if (map == null) {
            return R.error().message("支付出错");
        }
        System.out.println(map);
        if (map.get("trade_state").equals("SUCCESS")) {
            //更改订单状态
            tPayLogService.updateOrderStatus(map);
            return R.ok().message("支付成功");
        }

        return R.ok().code(25000).message("支付中");
    }

}


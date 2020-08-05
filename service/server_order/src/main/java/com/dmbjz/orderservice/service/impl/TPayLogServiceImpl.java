package com.dmbjz.orderservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.orderservice.entity.TOrder;
import com.dmbjz.orderservice.entity.TPayLog;
import com.dmbjz.orderservice.mapper.TPayLogMapper;
import com.dmbjz.orderservice.service.TOrderService;
import com.dmbjz.orderservice.service.TPayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmbjz.orderservice.utils.HttpClient;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author dmbjz
 * @since 2020-08-01
 */
@Service
public class TPayLogServiceImpl extends ServiceImpl<TPayLogMapper, TPayLog> implements TPayLogService {

    @Autowired
    private TOrderService orderService;

    //创建订单
    @Override
    public Map createNative(String orderNo) {

        try {

            //根据订单号查询订单信息
            QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("order_no",orderNo);
            TOrder order = orderService.getOne(queryWrapper);

            //生成二维码
            Map m = new HashMap();
            m.put("appid", "wx0609f8351dca9750");
            m.put("mch_id", "1536725911");
            m.put("nonce_str", WXPayUtil.generateNonceStr());
            m.put("body", order.getCourseTitle());
            m.put("out_trade_no", orderNo);
            m.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue()+"");
            m.put("spbill_create_ip", "127.0.0.1");
            m.put("notify_url", "http://www.txjava.cn");
            m.put("trade_type", "NATIVE");

            //变成XML格式
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            client.setXmlParam(WXPayUtil.generateSignedXml(m,"txjavayingmulaoshi01234567891234"));
            client.setHttps(true);
            client.post();

            //返回请求结果，转换Map集合
            String content = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(content);

            //最终数据封装
            Map map = new HashMap<>();
            map.put("out_trade_no", orderNo);
            map.put("course_id", order.getCourseId());
            map.put("total_fee", order.getTotalFee());
            map.put("result_code", resultMap.get("result_code"));
            map.put("code_url", resultMap.get("code_url"));

            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }

    }

    //查询订单状态
    @Override
    public Map<String, String> queryPayStatus(String orderNo) {

        try {

            //1、封装参数
            Map m = new HashMap<>();
            m.put("appid", "wx0609f8351dca9750");
            m.put("mch_id", "1536725911");
            m.put("out_trade_no", orderNo);
            m.put("nonce_str", WXPayUtil.generateNonceStr());

            //2、设置请求
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(m, "txjavayingmulaoshi01234567891234"));
            client.setHttps(true);
            client.post();

            //3、返回第三方的数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            return resultMap;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void updateOrderStatus(Map<String, String> map) {

        //获取订单id
        String orderNo = map.get("out_trade_no");
        //根据订单id查询订单信息
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderNo);
        TOrder order = orderService.getOne(wrapper);

        if(order.getStatus().intValue() == 1) return;
        order.setStatus(1);
        orderService.updateById(order);

        //记录支付日志
        TPayLog payLog=new TPayLog();
        payLog.setOrderNo(order.getOrderNo());//支付订单号
        payLog.setPayTime(new Date());
        payLog.setPayType(1);//支付类型
        payLog.setTotalFee(order.getTotalFee());//总金额(分)
        payLog.setTradeState(map.get("trade_state"));//支付状态
        payLog.setTransactionId(map.get("transaction_id"));
        payLog.setAttr(JSONObject.toJSONString(map));
        baseMapper.insert(payLog);//插入到支付日志表

    }


}

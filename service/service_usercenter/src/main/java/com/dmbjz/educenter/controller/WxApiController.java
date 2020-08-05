package com.dmbjz.educenter.controller;

import com.dmbjz.commonutils.JwtUtils;
import com.dmbjz.educenter.entity.UcenterMember;
import com.dmbjz.educenter.service.UcenterMemberService;
import com.dmbjz.educenter.utils.ConstantWxUtiles;
import com.dmbjz.educenter.utils.HttpClientUtils;
import com.dmbjz.servicebase.exceptionHandler.LightException;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

@Controller
@RequestMapping("/api/ucenter/wx")
public class WxApiController {

    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation("扫描人信息，添加数据")
    @GetMapping("callback")
    public String callback(String code,String state){

        try {

            //向认证服务器发送请求换取access_token
            String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                    "?appid=%s" +
                    "&secret=%s" +
                    "&code=%s" +
                    "&grant_type=authorization_code";
            //拼接参数
            String accessTokenUrl = String.format(baseAccessTokenUrl,
                    ConstantWxUtiles.WX_OPEN_APP_ID,
                    ConstantWxUtiles.WX_OPEN_APP_SECRET,
                    code);

            //使用HttpClient获取
            String result = HttpClientUtils.get(accessTokenUrl);

            //解析json字符串
            Gson gson = new Gson();
            HashMap map = gson.fromJson(result, HashMap.class);
            String accessToken = (String)map.get("access_token");
            String openid = (String)map.get("openid");

            //查询是否有微信登录记录
            UcenterMember count = memberService.getOpenId(openid);
            if (count==null){

                //访问微信的资源服务器，获取用户信息
                String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                        "?access_token=%s" +
                        "&openid=%s";
                String userInfoUrl = String.format(baseUserInfoUrl,accessToken,openid);
                String s = HttpClientUtils.get(userInfoUrl);
                System.out.println(s);

                //将json转为Map类型
                Gson userge = new Gson();
                HashMap fromJson = userge.fromJson(s, HashMap.class);
                String nickname = (String) fromJson.get("nickname");
                String headimgurl = (String) fromJson.get("headimgurl");

                count.setNickname(nickname);
                count.setOpenid(openid);
                count.setAvatar(headimgurl);
                memberService.save(count);
            }

            String token = JwtUtils.getJwtToken(count.getId(), count.getNickname());

            return "redirect:http://localhost:3000?token="+token;

        } catch (Exception e) {

            throw new LightException(20001, "获取access_token失败");

        }

    }

    @ApiOperation("微信登录图")
    @GetMapping("login")
    public String getWX(){

        // 微信开放平台授权baseUrl
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //对重定向URL进行编码
        String redirect = ConstantWxUtiles.WX_OPEN_REDIRECT_URL;
        try {
            redirect = URLEncoder.encode(redirect, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //往 %s 设置值
        String url = String.format(
                baseUrl,
                ConstantWxUtiles.WX_OPEN_APP_ID,
                ConstantWxUtiles.WX_OPEN_REDIRECT_URL,
                "atguigu"
            );

        return "redirect:"+url;
    }


}

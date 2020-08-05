package com.dmbjz.eduservice.controller;

import com.dmbjz.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "后台管理用户登录")
@RequestMapping("/eduservice/usr")
public class EduLoginController {

    @ApiOperation(value = "后台登录")
    @PostMapping(path = "/login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @ApiOperation(value = "获取账号信息")
    @GetMapping(path = "/info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "dmbjz").data("avatar","https://picsum.photos/200/300");
    }

    @ApiOperation("用户登出")
    @PostMapping(path = "logout")
    public R logout(){
        return R.ok().data("roles",null).data("name",null).data("avatar",null);
    }

}

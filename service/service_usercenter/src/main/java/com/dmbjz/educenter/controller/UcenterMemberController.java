package com.dmbjz.educenter.controller;

import com.dmbjz.commonutils.JwtUtils;
import com.dmbjz.commonutils.R;
import com.dmbjz.educenter.entity.UcenterMember;
import com.dmbjz.educenter.entity.vo.RegisterVo;
import com.dmbjz.educenter.service.UcenterMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author dmbjz
 * @since 2020-07-29
 */
@RestController
@RequestMapping("/educenter/member")
@Api(description = "登录功能")
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public R userLogin(@RequestBody UcenterMember member){
        //返回token值
        String token = memberService.login(member);
        return R.ok().data("token",token);
    }

    @ApiOperation("用户注册")
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo){
        boolean register = memberService.register(registerVo);
        if (register){
            return R.ok();
        }else{
            return R.error().message("登录错误，请检查输入");
        }

    }

    @ApiOperation("获取用户Token")
    @GetMapping("getMemberInfo")
    public R getUserLoginInfo(HttpServletRequest request){
        //通过JWT获取token，解析获得ID进行查询
        String userId = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember user = memberService.getById(userId);
        return R.ok().data("userInfo",user);
    }

    @ApiOperation("根据用户ID查询注册信息")
    @PostMapping("getInfoUc/{id}")
    public UcenterMember getInfo(@PathVariable("id") String id){
        //根据用户id获取用户信息
        UcenterMember ucenterMember = memberService.getById(id);
        return ucenterMember;
    }

    @ApiOperation("查询某一天注册的总人数")
    @GetMapping("countRegister/{day}")
    public Integer countRegister(@PathVariable("day")String day){
        Integer count = memberService.selectCountByDay(day);
        return count;
    }

}


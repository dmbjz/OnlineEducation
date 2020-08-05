package com.dmbjz.educms.controller;

import com.dmbjz.commonutils.R;
import com.dmbjz.educms.entity.CrmBanner;
import com.dmbjz.educms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edubanner/banneruser")
@Api(description = "轮播图前台管理")
public class BannerUserController {

    @Autowired
    private CrmBannerService crmBannerService;

    //查询前三条轮播图
    @GetMapping("getAllBanner")
    @ApiOperation("查询首页轮播图")
    @Cacheable(value = "branner",key = "'IndexBrannerList'")
    public R selectAllBranner(){
        List<CrmBanner> list = crmBannerService.selectAllBanner();
        return R.ok().data("list",list);
    }


}

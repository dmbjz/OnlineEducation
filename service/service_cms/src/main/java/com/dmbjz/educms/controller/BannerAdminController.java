package com.dmbjz.educms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.commonutils.R;
import com.dmbjz.educms.entity.CrmBanner;
import com.dmbjz.educms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edubanner/banneradmin")
@Api(description = "轮播图后台管理")
public class BannerAdminController {

    @Autowired
    private CrmBannerService crmBannerService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @ApiOperation("轮播图后台分页")
    @GetMapping("getbranner/{index}/{limit}")
    public R pageBranner(@PathVariable("index")Long index, @PathVariable("limit")Long limit){
        Page<CrmBanner> pageBanner = new Page<>(index,limit);
        crmBannerService.page(pageBanner,null);
        return R.ok().data("items",pageBanner.getRecords()).data("total",pageBanner.getTotal());
    }


    @ApiOperation("添加轮播图")
    @PostMapping("addbranner")
    public R addBranner(@RequestBody CrmBanner crmBanner){
        crmBannerService.save(crmBanner);
        redisTemplate.delete("branner::IndexBrannerList");
        return R.ok();
    }


    @ApiOperation("修改轮播图")
    @PostMapping("updatebranner")
    public R updateById(@RequestBody CrmBanner banner) {
        crmBannerService.updateById(banner);
        redisTemplate.delete("branner::IndexBrannerList");
        return R.ok();
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping("removebranner/{id}")
    public R remove(@PathVariable("id") String id) {
        crmBannerService.removeById(id);
        redisTemplate.delete("branner::IndexBrannerList");
        return R.ok();
    }

    @ApiOperation("获取Banner")
    @GetMapping("get/{id}")
    public R get(@PathVariable("id") String id) {
        CrmBanner banner = crmBannerService.getById(id);
        return R.ok().data("item", banner);
    }

}


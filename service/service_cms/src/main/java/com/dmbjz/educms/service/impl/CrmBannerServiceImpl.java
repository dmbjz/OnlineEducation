package com.dmbjz.educms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.educms.entity.CrmBanner;
import com.dmbjz.educms.mapper.CrmBannerMapper;
import com.dmbjz.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-29
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    //查询前三条轮播图
    @Override
    public List<CrmBanner> selectAllBanner() {

        //根据ID进行排序,只显示前三条记录
        QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 3");

        List<CrmBanner> banners = baseMapper.selectList(queryWrapper);
        return banners;
    }



}

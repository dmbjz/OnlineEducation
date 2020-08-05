package com.dmbjz.educenter.service;

import com.dmbjz.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmbjz.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-29
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember member);

    boolean register(RegisterVo registerVo);

    UcenterMember getOpenId(String openid);

    Integer selectCountByDay(String day);
}

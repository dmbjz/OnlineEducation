package com.dmbjz.educenter.mapper;

import com.dmbjz.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author dmbjz 
 * @since 2020-07-29
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {

    Integer selectCountByDay(String day);

}

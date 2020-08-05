package com.dmbjz.educenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.commonutils.JwtUtils;
import com.dmbjz.commonutils.R;
import com.dmbjz.educenter.entity.UcenterMember;
import com.dmbjz.educenter.entity.vo.RegisterVo;
import com.dmbjz.educenter.mapper.UcenterMemberMapper;
import com.dmbjz.educenter.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmbjz.educenter.utils.MD5;
import com.dmbjz.servicebase.exceptionHandler.LightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author dmbjz
 * @since 2020-07-29
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //用户登录
    @Override
    public String login(UcenterMember member) {

        //获取手机号和密码
        String mobile = member.getMobile();
        String password = member.getPassword();
        if (StringUtils.isEmpty(mobile) && StringUtils.isEmpty(password)) {
            throw new LightException(20001, "非法参数");
        }

        //判断是否有注册过
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        UcenterMember ucenterMember = baseMapper.selectOne(queryWrapper);
        if (ucenterMember == null) {
            throw new LightException(20001, "用户不存在");
        }

        String md5password = MD5.encrypt(password);
        if (!md5password.equals(ucenterMember.getPassword())) {
            throw new LightException(20001, "密码错误");
        }

        if (ucenterMember.getIsDisabled()) {
            throw new LightException(20001, "该账户被禁用");
        }

        //通过JWT生成Token
        String token = JwtUtils.getJwtToken(ucenterMember.getId(), ucenterMember.getNickname());
        return token;

    }

    //用户注册
    @Override
    public boolean register(RegisterVo registerVo) {
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();
        if (StringUtils.isEmpty(code)||StringUtils.isEmpty(mobile)||StringUtils.isEmpty(nickname)||StringUtils.isEmpty(password)){
            throw new LightException(20001,"参数非空异常");
        }
        //获取Redis里的数据
        String s = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(s)){
            throw new LightException(20001,"验证码错误");
        }
        //判断手机号是否重复
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer integer = baseMapper.selectCount(wrapper);
        if (integer>0){
            throw new LightException(20001,"手机号已注册");
        }

        //添加到数据库
        UcenterMember u = new UcenterMember();
        u.setMobile(mobile);
        u.setPassword(MD5.encrypt(password));
        u.setNickname(nickname);
        u.setIsDisabled(false);
        u.setAvatar("https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg");
        baseMapper.insert(u);

        return true;
    }

    @Override
    public UcenterMember getOpenId(String openid) {
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid",openid);
        UcenterMember ucenterMember = baseMapper.selectOne(queryWrapper);
        return ucenterMember;
    }

    @Override
    public Integer selectCountByDay(String day) {
        return baseMapper.selectCountByDay(day);
    }

}

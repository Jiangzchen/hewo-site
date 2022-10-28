package org.hewo.modules.auth.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.exception.BusinessException;
import org.hewo.core.model.entity.R;
import org.hewo.core.utils.JwtUtil;
import org.hewo.modules.auth.model.dto.AuthDto;
import org.hewo.modules.auth.model.vo.AuthVo;
import org.hewo.modules.auth.service.AuthService;
import org.hewo.modules.system.mapper.SysUserMapper;
import org.hewo.modules.system.model.entity.SysUser;
import org.noear.solon.aspect.annotation.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Db
    private SysUserMapper sysUserMapper;

    @Override
    public R verifyAuth(AuthDto req) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("username", req.getUserCode());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);

        if (StrUtil.isBlankIfStr(sysUser)) {
            throw new BusinessException(-1,"请求错误");
        }

        if (ObjectUtil.equal(sysUser.getStatus(),0)) {
            throw new BusinessException(-1,"请联系管理员");
        }

        AuthVo authVo = new AuthVo();
        authVo.setUserCode(sysUser.getUsername());
        String sign = JwtUtil.sign(sysUser.getId(), sysUser.getUsername());
        authVo.setToken(sign);
        return R.ok("登录成功").data(authVo);
    }
}

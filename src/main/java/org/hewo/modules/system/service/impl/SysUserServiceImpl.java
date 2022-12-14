package org.hewo.modules.system.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.constant.SystemConstant;
import org.hewo.core.exception.BusinessException;
import org.hewo.core.model.entity.R;
import org.hewo.core.utils.ThreadLocalGroup;
import org.hewo.modules.system.mapper.SysMenuMapper;
import org.hewo.modules.system.mapper.SysRoleMapper;
import org.hewo.modules.system.mapper.SysUserMapper;
import org.hewo.modules.system.model.dto.SysUserSaveDto;
import org.hewo.modules.system.model.dto.UpdatePswdDto;
import org.hewo.modules.system.model.entity.SysUser;
import org.hewo.modules.system.model.vo.SysUserVo;
import org.hewo.modules.system.service.SysUserService;
import org.noear.snack.core.utils.StringUtil;
import org.noear.solon.aspect.annotation.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Db
    private SysUserMapper sysUserMapper;
    @Db
    private SysMenuMapper sysMenuMapper;
    @Db
    private SysRoleMapper sysRoleMapper;

    @Override
    public R save(SysUserSaveDto req) {
        String userId = IdUtil.fastSimpleUUID();
        req.setId(userId);
        String newPwd = DigestUtil.md5Hex(req.getPassword());
        req.setPassword(newPwd);
        String userCreateId = ThreadLocalGroup.getUserId();
        req.setUserIdCreate(userCreateId);
        Date now = new Date();
        req.setGmtCreate(now);
        req.setGmtModified(now);
        sysUserMapper.insert(req);
        return R.ok().data(userId);
    }

    @Override
    public R list(int page, int pageSize, String req) {
        IPage<SysUserVo> pageModel = Page.of(page,pageSize);
        IPage<SysUserVo> pages = sysUserMapper.selectPageList(pageModel,req);
        return R.ok().data(pages.getRecords());
    }

    @Override
    public R info(String req) {
        SysUser sysUser = sysUserMapper.selectById(req);
        return R.ok().data(sysUser);
    }

    @Override
    public R batchRemove(List<String> req) {
        sysUserMapper.delete(null);
        return R.ok();
    }

    @Override
    public R updatePswd(UpdatePswdDto req) {
        return null;
    }

    @Override
    public R enable(List<String> req) {
        for (String dto : req) {
            SysUser sysUser = new SysUser();
            sysUser.setId(dto);
            sysUser.setStatus(SystemConstant.StatusType.ENABLE.getValue());
            sysUserMapper.updateById(sysUser);
        }
        return R.ok();
    }

    @Override
    public R disable(List<String> req) {
        for (String dto : req) {
            SysUser sysUser = new SysUser();
            sysUser.setId(dto);
            sysUser.setStatus(SystemConstant.StatusType.DISABLE.getValue());
            sysUserMapper.updateById(sysUser);
        }
        return null;
    }

    @Override
    public R reset(SysUserSaveDto req) {
        return null;
    }

    @Override
    public R listUserPerms(String userId) {
        List<String> perms = sysMenuMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for(String perm : perms) {
            if(StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return R.msgNotCheckNull(permsSet);
    }

    @Override
    public R listUserRoles(String userId) {
        List<String> roles = sysRoleMapper.listUserRoles(userId);
        Set<String> rolesSet = new HashSet<>();
        for(String role : roles) {
            if(StringUtils.isNotBlank(role)) {
                rolesSet.addAll(Arrays.asList(role.trim().split(",")));
            }
        }
        return R.msgNotCheckNull(rolesSet);
    }

    @Override
    public R infoMe() {
        String userId = ThreadLocalGroup.getUserId();
        if (StringUtil.isEmpty(userId)) {
            throw new BusinessException(-1,"?????????????????????token");
        }
        SysUser sysUser = sysUserMapper.selectById(userId);
        sysUser.setPassword(null);
        return R.ok().data(sysUser);
    }
}

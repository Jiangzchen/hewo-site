package org.hewo.modules.system.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.exception.BusinessException;
import org.hewo.core.model.entity.R;
import org.hewo.core.utils.SnowFlakeUtil;
import org.hewo.modules.system.mapper.SysUserMapper;
import org.hewo.modules.system.model.dto.SysUserSaveDto;
import org.hewo.modules.system.model.entity.SysUser;
import org.hewo.modules.system.model.vo.SysUserVo;
import org.hewo.modules.system.service.SysUserService;
import org.noear.solon.aspect.annotation.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Db
    private SysUserMapper sysUserMapper;

    @Override
    public R create(SysUserSaveDto req) {
        String userId = IdUtil.fastSimpleUUID();
        req.setId(userId);
        sysUserMapper.insert(req);

        // if (userId>0L) {
        //     throw new BusinessException(-1,"请求错误");
        // }

        return R.ok().data(userId);
    }

    @Override
    public R page(int page, int pageSize, String req) {
        IPage<SysUser> data = Page.of(page,pageSize);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq("username", req);
        IPage<SysUser> d = sysUserMapper.selectPage(data, queryWrapper);
        return R.ok().data(d.getRecords());
    }
}

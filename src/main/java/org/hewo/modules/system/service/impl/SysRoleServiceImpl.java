package org.hewo.modules.system.service.impl;

import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.model.entity.R;
import org.hewo.core.service.impl.AbstractServiceImpl;
import org.hewo.core.utils.ThreadLocalGroup;
import org.hewo.modules.system.mapper.SysMacroMapper;
import org.hewo.modules.system.mapper.SysRoleMapper;
import org.hewo.modules.system.model.dto.SysMacroSaveDto;
import org.hewo.modules.system.model.dto.SysRoleSaveDto;
import org.hewo.modules.system.service.SysRoleService;
import org.noear.solon.aspect.annotation.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl extends AbstractServiceImpl implements SysRoleService {
    @Db
    private SysRoleMapper sysRoleMapper;

    @Override
    public R list(int page, int pageSize, String req) {
        return null;
    }

    @Override
    public R save(SysRoleSaveDto req) {
        String id = this.getId();
        req.setId(id);

        String userId = ThreadLocalGroup.getUserId();
        req.setUserIdCreate(userId);
        Date now = new Date();

        req.setGmtCreate(now);
        req.setGmtModified(now);

        return R.ok().data(req.getId());
    }

    @Override
    public R update(SysRoleSaveDto req) {
        return null;
    }

    @Override
    public R info(String req) {
        return null;
    }

    @Override
    public R batchRemove(List<String> req) {
        sysRoleMapper.delete(null);
        return R.ok();
    }
}

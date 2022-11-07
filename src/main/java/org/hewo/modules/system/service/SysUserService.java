package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.SysUserSaveDto;
import org.hewo.modules.system.model.dto.UpdatePswdDto;

import java.util.List;
import java.util.Set;

public interface SysUserService {
    R save(SysUserSaveDto req);

    R list(int page, int pageSize, String req);

    R info(String req);

    R batchRemove(List<String> req);

    R updatePswd(UpdatePswdDto req);

    R enable(List<String> req);

    R disable(List<String> req);

    R reset(SysUserSaveDto req);

    // 查询用户权限集合
    R listUserPerms(String userId);

    // 查询用户角色集合
    R listUserRoles(String userId);

    R infoMe();
}

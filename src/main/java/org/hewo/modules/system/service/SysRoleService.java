package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.SysMacroSaveDto;
import org.hewo.modules.system.model.dto.SysRoleSaveDto;

import java.util.List;

public interface SysRoleService {
    R list(int page, int pageSize, String req);

    R save(SysRoleSaveDto req);

    R update(SysRoleSaveDto req);

    R info(String req);

    R batchRemove(List<String> req);
}

package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.SysUserSaveDto;

public interface SysUserService {
    R create(SysUserSaveDto req);

    R page(int page, int pageSize, String req);
}

package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.SysMenuSaveDto;

import java.util.List;

public interface SysMenuService {
    R batchRemove(List<String> req);

    R save(SysMenuSaveDto req);

    R info(String req);

    R list(int page, int pageSize, String req);
}

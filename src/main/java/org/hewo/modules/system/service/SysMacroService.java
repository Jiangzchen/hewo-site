package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.SysMacroSaveDto;
import org.hewo.modules.system.model.dto.SysRoleSaveDto;

import java.util.List;

public interface SysMacroService {
    R list(int page, int pageSize, String req);

    R save(SysMacroSaveDto req);

    R update(SysMacroSaveDto req);

    R info(String req);

    R batchRemove(List<String> req);
}

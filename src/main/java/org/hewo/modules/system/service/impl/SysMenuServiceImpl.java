package org.hewo.modules.system.service.impl;

import lombok.Data;
import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.SysMenuSaveDto;
import org.hewo.modules.system.service.SysMenuService;

import java.util.List;

@Data
public class SysMenuServiceImpl implements SysMenuService {
    @Override
    public R batchRemove(List<String> req) {
        return null;
    }

    @Override
    public R save(SysMenuSaveDto req) {
        return null;
    }

    @Override
    public R info(String req) {
        return null;
    }

    @Override
    public R list(int page, int pageSize, String req) {
        return null;
    }
}

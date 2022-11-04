package org.hewo.modules.system.service.impl;

import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.model.entity.R;
import org.hewo.modules.system.mapper.SysMacroMapper;
import org.hewo.modules.system.model.dto.SysMacroSaveDto;
import org.hewo.modules.system.model.entity.SysMacro;
import org.hewo.modules.system.service.SysMacroService;
import org.noear.solon.aspect.annotation.Service;

import java.util.List;

@Service
public class SysMacroServiceImpl implements SysMacroService {
    @Db
    private SysMacroMapper sysMacroMapper;

    @Override
    public R list(int page, int pageSize, String req) {
        return null;
    }

    @Override
    public R save(SysMacroSaveDto req) {
        return null;
    }

    @Override
    public R update(SysMacroSaveDto req) {
        return null;
    }

    @Override
    public R info(String req) {
        return null;
    }

    @Override
    public R batchRemove(List<String> req) {
        sysMacroMapper.delete(null);
        return R.ok();
    }
}

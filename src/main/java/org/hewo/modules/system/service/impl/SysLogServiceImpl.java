package org.hewo.modules.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.model.entity.R;
import org.hewo.modules.system.mapper.SysLogMapper;
import org.hewo.modules.system.model.vo.SysLogVo;
import org.hewo.modules.system.service.SysLogService;
import org.noear.solon.aspect.annotation.Service;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Db
    private SysLogMapper sysLogMapper;

    @Override
    public R list(int page, int pageSize, String req) {
        IPage<SysLogVo> pageModel = Page.of(page,pageSize);
        IPage<SysLogVo> pages = sysLogMapper.selectPageList(pageModel,req);
        return R.ok().data(pages.getRecords());
    }

    @Override
    public R batchRemove(List<String> req) {
        sysLogMapper.deleteBatchIds(req);
        return R.ok();
    }

    @Override
    public R batchRemoveAll() {
        sysLogMapper.delete(null);
        return R.ok();
    }
}

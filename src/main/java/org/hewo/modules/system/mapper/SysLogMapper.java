package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.hewo.modules.system.model.entity.SysLog;
import org.hewo.modules.system.model.vo.SysLogVo;

@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
    IPage<SysLogVo> selectPageList(IPage<SysLogVo> pageModel, String req);
}

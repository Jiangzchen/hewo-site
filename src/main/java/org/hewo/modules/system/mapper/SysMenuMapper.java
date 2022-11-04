package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hewo.modules.system.model.entity.SysMenu;
import org.hewo.modules.system.model.entity.SysRole;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
}

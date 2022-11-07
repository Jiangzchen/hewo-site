package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hewo.modules.system.model.entity.SysRole;
import org.hewo.modules.system.model.entity.SysRoleMenu;
import org.hewo.modules.system.model.entity.SysUserRole;

@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
}

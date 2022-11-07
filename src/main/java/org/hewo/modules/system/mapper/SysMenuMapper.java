package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hewo.modules.system.model.entity.SysMenu;
import org.hewo.modules.system.model.entity.SysRole;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    // 用户权限菜单
    List<String> listUserPerms(@Param("userId") String userId);
}

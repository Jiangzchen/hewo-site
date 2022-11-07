package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hewo.modules.system.model.entity.SysRole;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<String> listUserRoles(@Param("userId") String userId);
}

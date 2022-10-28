package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hewo.modules.system.model.entity.SysUser;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}

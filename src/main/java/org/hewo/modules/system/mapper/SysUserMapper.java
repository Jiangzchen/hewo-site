package org.hewo.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hewo.modules.system.model.entity.SysUser;
import org.hewo.modules.system.model.vo.SysUserVo;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    IPage<SysUserVo> selectPageList(@Param("pageModel") IPage<SysUserVo> pageModel, @Param("req") String req);
}

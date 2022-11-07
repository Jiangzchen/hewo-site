package org.hewo.modules.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hewo.modules.article.model.entity.PmCustomizeColumn;

import java.util.Map;

@Mapper
public interface PmCustomizeColumnMapper extends BaseMapper<PmCustomizeColumn> {

    Map<String, Object> queryCustomDataById(@Param("tableName") String tableName, @Param("id") String id);
}

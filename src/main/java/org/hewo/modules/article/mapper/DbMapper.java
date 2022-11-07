package org.hewo.modules.article.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DbMapper {
    Integer isExistTable(@Param("tableName") String tableName);

    Integer isExistField(@Param("tableName") String tableName, @Param("fieldName") String fieldName);

    Integer insert(@Param("sql") String sql);
}

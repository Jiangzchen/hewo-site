package org.hewo.modules.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hewo.modules.article.model.entity.PmCustomizeColumn;
import org.hewo.modules.article.model.entity.PmCustomizeColumnValue;

@Mapper
public interface PmCustomizeColumnValueMapper extends BaseMapper<PmCustomizeColumnValue> {
}

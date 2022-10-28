package org.hewo.modules.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hewo.modules.article.model.entity.Article;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}

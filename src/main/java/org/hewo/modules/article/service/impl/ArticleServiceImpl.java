package org.hewo.modules.article.service.impl;

import cn.hutool.core.util.IdUtil;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.model.entity.R;
import org.hewo.core.utils.SnowFlakeUtil;
import org.hewo.modules.article.mapper.ArticleMapper;
import org.hewo.modules.article.model.dto.ArticleSaveDto;
import org.hewo.modules.article.service.ArticleService;
import org.noear.solon.aspect.annotation.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Db
    private ArticleMapper articleMapper;

    @Override
    public R create(ArticleSaveDto req) {
        String articleSaveId = IdUtil.fastSimpleUUID();
        req.setId(articleSaveId);
        articleMapper.insert(req);
        return R.ok().data(articleSaveId);
    }
}

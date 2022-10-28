package org.hewo.modules.article.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.article.model.dto.ArticleSaveDto;

public interface ArticleService {
    R create(ArticleSaveDto req);
}

package org.hewo.modules.article.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.article.model.dto.PmArticleSaveDto;

public interface PmArticleService {
    R save(PmArticleSaveDto req);

    R info(String req);
}

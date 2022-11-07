package org.hewo.modules.article.model.dto;

import lombok.Data;
import org.hewo.modules.article.model.entity.PmArticle;

import java.util.Map;

@Data
public class PmArticleSaveDto extends PmArticle {

    // 自定义字段
    private Map<String, Object> customFieldMap;
}

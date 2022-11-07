package org.hewo.modules.article.model.vo;

import lombok.Data;

import java.util.Map;

@Data
public class PmArticleVo {
    private String id;
    private String content;
    private String title;
    // 自定义字段
    private Map<String, Object> customFieldMap;
}

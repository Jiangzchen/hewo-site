package org.hewo.modules.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("pm_article")
public class Article implements Serializable {
    private String id;
    private String content;
    private String title;
}

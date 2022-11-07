package org.hewo.modules.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pm_customize_column")
public class PmCustomizeColumn {
    private String id;
    private String code;
    private String name;
    private String type;
    private String defaultValue;
}

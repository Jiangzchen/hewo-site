package org.hewo.modules.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pm_customize_column_value")
public class PmCustomizeColumnValue {
    private String id;
    private String customizeColumnId;
    private String customizeCode;
    private String value;
}

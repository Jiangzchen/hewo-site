package org.hewo.modules.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_macro")
public class SysMacro implements Serializable {
    private String id;
    private Integer typeId;
    private String name;
    private String value;
    private Integer status;
    private Integer type;
    private String remark;
    private String orderNum;
    private Date gmtCreate;
    private Date gmtModified;
}

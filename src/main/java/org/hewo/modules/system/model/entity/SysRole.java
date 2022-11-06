package org.hewo.modules.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_role")
public class SysRole implements Serializable {
    private String id;
    private String roleName;
    private String roleSign;
    private String remark;
    private String userIdCreate;
    private Date gmtCreate;
    private Date gmtModified;
}

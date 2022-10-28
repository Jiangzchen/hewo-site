package org.hewo.modules.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_user")
public class SysUser implements Serializable {
    private String id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private Integer status;
    private String remark;
    private Long userIdCreate;
    private Date gmtCreate;
    private Date gmtModified;
}

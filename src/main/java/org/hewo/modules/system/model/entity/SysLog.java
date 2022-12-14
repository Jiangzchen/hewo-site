package org.hewo.modules.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_log")
public class SysLog implements Serializable {
    private String id;
    private String ip;
    private Date gmtCreate;
}

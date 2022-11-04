package org.hewo.modules.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_menu")
public class SysMenu implements Serializable {
    private String id;
}

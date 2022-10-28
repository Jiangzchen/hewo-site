package org.hewo.modules.system.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable {
    private Long id;
    private String ip;
    private Date gmtCreate;
}

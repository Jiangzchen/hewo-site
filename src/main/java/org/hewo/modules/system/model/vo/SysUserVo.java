package org.hewo.modules.system.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserVo implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String mobile;
}

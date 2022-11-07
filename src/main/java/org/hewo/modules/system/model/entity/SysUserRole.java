package org.hewo.modules.system.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;
}

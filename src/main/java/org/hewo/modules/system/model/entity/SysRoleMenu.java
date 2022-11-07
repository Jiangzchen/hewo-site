package org.hewo.modules.system.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

}

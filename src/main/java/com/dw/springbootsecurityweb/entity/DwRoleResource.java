package com.dw.springbootsecurityweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Byron
 * @since 2022-06-21
 */
@TableName("dw_role_resource")
public class DwRoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色资源表id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long resourceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "DwRoleResource{" +
            "id=" + id +
            ", roleId=" + roleId +
            ", resourceId=" + resourceId +
        "}";
    }
}

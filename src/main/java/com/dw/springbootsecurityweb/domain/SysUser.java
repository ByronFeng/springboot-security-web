package com.dw.springbootsecurityweb.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byron on 2022/6/27.
 */
@Data
public class SysUser implements Serializable {
    private  static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private String password;
    private String email;
    private Integer userStatus;

    private List<SysRole> sysRoles =new ArrayList<SysRole>();

}

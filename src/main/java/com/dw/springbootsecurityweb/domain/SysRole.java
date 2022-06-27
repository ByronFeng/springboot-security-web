package com.dw.springbootsecurityweb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Byron on 2022/6/27.
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID =1L;

    private Long roleId;
    private String roleName;
    private Integer roleStatus;
}

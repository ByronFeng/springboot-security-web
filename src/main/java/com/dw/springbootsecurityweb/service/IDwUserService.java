package com.dw.springbootsecurityweb.service;

import com.dw.springbootsecurityweb.domain.SysUser;
import com.dw.springbootsecurityweb.entity.DwUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dw.springbootsecurityweb.domain.DwUserDetails;

/**
 *
 * @author Byron
 * @since 2022-06-21
 */
public interface IDwUserService extends IService<DwUser> {

    DwUser getUserByid(Long id);

    SysUser loadUserByUsername(String username);

}



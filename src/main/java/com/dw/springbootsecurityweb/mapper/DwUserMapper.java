package com.dw.springbootsecurityweb.mapper;

import com.dw.springbootsecurityweb.domain.SysUser;
import com.dw.springbootsecurityweb.entity.DwUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dw.springbootsecurityweb.domain.DwUserDetails;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Byron
 * @since 2022-06-21
 */
public interface DwUserMapper extends BaseMapper<DwUser> {


    DwUser getUserById(Long id);

    SysUser loadUserByUsername(String username);

}

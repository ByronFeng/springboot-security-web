package com.dw.springbootsecurityweb.service.impl;

import com.dw.springbootsecurityweb.domain.SysUser;
import com.dw.springbootsecurityweb.entity.DwUser;
import com.dw.springbootsecurityweb.domain.DwUserDetails;
import com.dw.springbootsecurityweb.mapper.DwUserMapper;
import com.dw.springbootsecurityweb.service.IDwUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byron
 * @since 2022-06-21
 */
@Service
public class DwUserServiceImpl extends ServiceImpl<DwUserMapper, DwUser> implements IDwUserService {

    @Resource
    private DwUserMapper dwUserMapper;


    @Override
    public DwUser getUserByid(Long id) {

        System.out.println("调用了xxxxxx >>>>>>>>>>>>>");
        return dwUserMapper.getUserById(id);
    }

    /**
     * 根据用户名查询用户角色信息
     * @param username
     * @return
     */
    @Override
    public SysUser loadUserByUsername(String username) {
        return dwUserMapper.loadUserByUsername(username);
    }
}

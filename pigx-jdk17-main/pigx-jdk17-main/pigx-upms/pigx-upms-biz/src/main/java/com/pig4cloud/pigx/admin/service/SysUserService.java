/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.pig4cloud.pigx.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pigx.admin.api.dto.UserDTO;
import com.pig4cloud.pigx.admin.api.dto.UserInfo;
import com.pig4cloud.pigx.admin.api.entity.SysUser;
import com.pig4cloud.pigx.admin.api.vo.UserExcelVO;
import com.pig4cloud.pigx.admin.api.vo.UserVO;
import com.pig4cloud.pigx.common.core.util.R;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/31
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查询用户信息
     *
     * @param sysUser 用户
     * @return userInfo
     */
    UserInfo findUserInfo(SysUser sysUser);

    /**
     * 分页查询用户信息（含有角色信息）
     *
     * @param page    分页对象
     * @param userDTO 参数列表
     * @return
     */
    IPage getUsersWithRolePage(Page page, UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param ids 用户
     * @return boolean
     */
    Boolean deleteUserByIds(Long[] ids);

    /**
     * 更新当前用户基本信息
     *
     * @param userDto 用户信息
     * @return Boolean
     */
    R<Boolean> updateUserInfo(UserDTO userDto);

    /**
     * 更新指定用户信息
     *
     * @param userDto 用户信息
     * @return
     */
    Boolean updateUser(UserDTO userDto);

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserVO selectUserVoById(Long id);

    /**
     * 查询上级部门的用户信息
     *
     * @param username 用户名
     * @return R
     */
    List<SysUser> listAncestorUsers(String username);

    /**
     * 保存用户信息
     *
     * @param userDto DTO 对象
     * @return success/fail
     */
    Boolean saveUser(UserDTO userDto);

    /**
     * 查询全部的用户
     *
     * @param userDTO 查询条件
     * @param ids     目标列表
     * @return list
     */
    List<UserExcelVO> listUser(UserDTO userDTO, Long[] ids);

    /**
     * excel 导入用户
     *
     * @param excelVOList   excel 列表数据
     * @param bindingResult 错误数据
     * @return ok fail
     */
    R importUser(List<UserExcelVO> excelVOList, BindingResult bindingResult);

    /**
     * 注册用户
     *
     * @param userDto 用户信息
     * @return success/false
     */
    R<Boolean> registerUser(UserDTO userDto);

    /**
     * 锁定用户
     *
     * @param username 用户名
     * @return R
     */
    R<Boolean> lockUser(String username);

    /**
     * 修改密码
     *
     * @param userDto 用户信息
     * @return
     */
    R changePassword(UserDTO userDto);

    /**
     * 解绑社交登录
     *
     * @param type 社交登录类型
     * @return R
     */
    R unbinding(String type);

    /**
     * 校验密码
     *
     * @param username 用户名
     * @param password 密码
     * @return R
     */
    R checkPassword(String username, String password);

    /**
     * 根据角色ID列表获取用户ID列表接口
     *
     * @param roleIdList 角色ID列表
     * @return List<Long> 返回结果对象，包含根据角色ID列表获取到的用户ID列表信息
     */
    List<Long> listUserIdByRoleIds(List<Long> roleIdList);

    /**
     * 根据部门ID列表获取用户ID列表接口
     *
     * @param deptIdList 部门ID列表
     * @return List<Long> 返回结果对象，包含根据部门ID列表获取到的用户ID列表信息
     */
    List<SysUser> listUserIdByDeptIds(List<Long> deptIdList);

    /**
     * 重置用户密码
     *
     * @param userDto 用户信息
     * @return
     */
    R<Boolean> resetUserPassword(UserDTO userDto);
}

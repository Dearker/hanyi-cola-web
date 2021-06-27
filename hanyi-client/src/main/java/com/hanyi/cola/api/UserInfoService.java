package com.hanyi.cola.api;

import com.hanyi.cola.dto.UserInfoDTO;

import java.util.List;

/**
 * <p>
 * 用户详情服务接口
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 9:50 下午
 */
public interface UserInfoService {

    /**
     * 添加用户信息dto
     *
     * @param userInfoDto 用户信息dto
     */
    void addUserInfoDto(UserInfoDTO userInfoDto);


    /**
     * 找到所有用户信息列表
     *
     * @return 返回用户集合
     */
    List<UserInfoDTO> findAllUserInfoList();
}

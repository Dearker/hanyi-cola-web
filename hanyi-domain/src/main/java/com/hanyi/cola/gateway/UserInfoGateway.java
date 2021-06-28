package com.hanyi.cola.gateway;

import com.hanyi.cola.domain.UserInfoDO;

import java.util.List;

/**
 * <p>
 * 用户详情网关接口
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 8:31 下午
 */
public interface UserInfoGateway {

    /**
     * 新增用户详情
     *
     * @param userInfoDO 用户详情对象
     */
    void addUseInfo(UserInfoDO userInfoDO);

    /**
     * 查询所有的用户详情集合
     *
     * @return 返回用户集合
     */
    List<UserInfoDO> findAllList();

    /**
     * 注册用户信息
     *
     * @param userInfoDO 用户详情对象
     */
    void registerUserInfo(UserInfoDO userInfoDO);

    /**
     * 修改用户状态为在线
     *
     * @param userInfoDO 用户详情对象
     */
    void changeStatusToOnline(UserInfoDO userInfoDO);

    /**
     * 注销用户状态
     *
     * @param userInfoDO 用户详情对象
     */
    void cancelledUserStatus(UserInfoDO userInfoDO);
}

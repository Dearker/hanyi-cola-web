package com.hanyi.cola.common.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * <p>
 * 用户状态枚举
 * </p>
 *
 * @author wenchangwei
 * @date 2021/06/28
 * @since 2021/6/28 8:42 下午
 */
@Getter
public enum UserStatusEnum {

    /**
     * 已注册
     */
    REGISTERED(0, "已注册"),
    ONLINE(1, "在线"),
    OFFLINE(2, "离线"),
    ACCOUNT_CANCELLED(3, "已销户");

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 详情
     */
    private final String desc;

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    /**
     * 查询状态枚举
     *
     * @param statusId 状态标识
     * @return 返回状态类型
     */
    public static UserStatusEnum findStatus(Integer statusId) {
        return Stream.of(UserStatusEnum.values()).filter(s -> s.getStatus().equals(statusId)).findFirst().orElse(null);
    }

}

package com.hanyi.cola.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 用户详情领域对象
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 8:44 下午
 */
@Data
public class UserInfoDO implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 当前的状态
     */
    private Integer currentStatus;

    /**
     * 更新状态
     */
    private Integer updateStatus;

}

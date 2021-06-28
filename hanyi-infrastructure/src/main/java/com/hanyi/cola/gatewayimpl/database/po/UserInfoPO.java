package com.hanyi.cola.gatewayimpl.database.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户详情实体类，持久层对象
 *
 * @author weiwen
 * @date 2021/06/26
 */
@Data
@TableName(value ="user_info")
public class UserInfoPO implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户状态，0表示已注册，1表示在线，2表示离线，3表示已销户
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
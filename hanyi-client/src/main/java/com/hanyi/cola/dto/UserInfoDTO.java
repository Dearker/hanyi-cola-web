package com.hanyi.cola.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 用户详情传输对象
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 9:55 下午
 */
@Data
public class UserInfoDTO implements Serializable {

    /**
     * 用户名
     */
    @NotBlank
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户类型
     */
    private String userType;

}

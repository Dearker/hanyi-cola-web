package com.hanyi.cola.assembler;

import cn.hutool.core.collection.CollUtil;
import com.hanyi.cola.domain.UserInfoDO;
import com.hanyi.cola.dto.UserInfoDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息转换器
 * </p>
 *
 * @author wenchangwei
 * @date 2021/06/27
 * @since 2021/6/27 10:11 下午
 */
public final class UserInfoDtoAssembler {

    private UserInfoDtoAssembler() {
    }

    /**
     * 将传输对象转换成领域对象
     *
     * @param userInfoDTO 传输对象
     * @return 返回领域对象
     */
    public static UserInfoDO toDo(UserInfoDTO userInfoDTO) {
        UserInfoDO userInfoDo = new UserInfoDO();
        userInfoDo.setUserName(userInfoDTO.getUserName());

        return userInfoDo;
    }

    /**
     * 将领域对象转换成传输对象
     *
     * @param userInfoDo 领域对象
     * @return 返回传输对象
     */
    public static UserInfoDTO toDto(UserInfoDO userInfoDo) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserName(userInfoDo.getUserName());
        return userInfoDTO;
    }

    /**
     * 将领域对象集合转换成传输对象集合
     *
     * @param userInfoDOList 领域对象集合
     * @return 返回传输对象集合
     */
    public static List<UserInfoDTO> toDtoList(List<UserInfoDO> userInfoDOList) {
        if (CollUtil.isEmpty(userInfoDOList)) {
            return Collections.emptyList();
        }
        return userInfoDOList.stream().map(UserInfoDtoAssembler::toDto).collect(Collectors.toList());
    }

}

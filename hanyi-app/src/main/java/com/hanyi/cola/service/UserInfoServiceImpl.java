package com.hanyi.cola.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.hanyi.cola.api.UserInfoService;
import com.hanyi.cola.assembler.UserInfoDtoAssembler;
import com.hanyi.cola.domain.UserInfoDO;
import com.hanyi.cola.dto.UserInfoDTO;
import com.hanyi.cola.gateway.UserInfoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户详情逻辑层
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 9:54 下午
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    /**
     * 用户信息网关
     */
    private final UserInfoGateway userInfoGateway;

    /**
     * 添加用户信息dto
     *
     * @param userInfoDto 用户信息dto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserInfoDto(UserInfoDTO userInfoDto) {
        UserInfoDO userInfoDo = UserInfoDtoAssembler.toDo(userInfoDto);
        userInfoGateway.addUseInfo(userInfoDo);
    }

    /**
     * 找到所有用户信息列表
     *
     * @return 返回用户集合
     */
    @Override
    public List<UserInfoDTO> findAllUserInfoList() {
        List<UserInfoDO> infoGatewayAllList = userInfoGateway.findAllList();
        return UserInfoDtoAssembler.toDtoList(infoGatewayAllList);
    }
}

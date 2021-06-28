package com.hanyi.cola.gatewayimpl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.hanyi.cola.assembler.UserInfoAssembler;
import com.hanyi.cola.common.enums.StatusEventEnum;
import com.hanyi.cola.common.enums.UserStatusEnum;
import com.hanyi.cola.domain.UserInfoDO;
import com.hanyi.cola.gateway.UserInfoGateway;
import com.hanyi.cola.gatewayimpl.database.mapper.UserInfoMapper;
import com.hanyi.cola.gatewayimpl.database.po.UserInfoPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 用户详情基础处理层，如果需要进行多数据源的扩展，添加UserInfoGateway接口的多个实现即可
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 8:49 下午
 */
@Service(value = "mysqlUserInfoGateway")
@RequiredArgsConstructor
public class UserInfoGatewayImpl implements UserInfoGateway {

    /**
     * 用户信息映射器
     */
    private final UserInfoMapper userInfoMapper;

    /**
     * 新增用户详情
     *
     * @param userInfoDO 用户详情对象
     */
    @Override
    public void addUseInfo(UserInfoDO userInfoDO) {
        UserInfoPO userInfoPo = UserInfoAssembler.toPo(userInfoDO);
        userInfoMapper.insert(userInfoPo);
    }

    /**
     * 查询所有的用户详情集合
     *
     * @return 返回用户集合
     */
    @Override
    public List<UserInfoDO> findAllList() {
        List<UserInfoPO> userInfoPoList = userInfoMapper.selectList(null);
        return UserInfoAssembler.toDoList(userInfoPoList);
    }

    /**
     * 注册用户信息
     *
     * @param userInfoDO 用户详情对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerUserInfo(UserInfoDO userInfoDO) {
        StateMachineBuilder<UserStatusEnum, StatusEventEnum, String> machineBuilder = StateMachineBuilderFactory.create();

        Integer currentStatus = userInfoDO.getCurrentStatus();
        machineBuilder.internalTransition()
                .within(UserStatusEnum.REGISTERED)
                .on(StatusEventEnum.REGISTER_EVENT)
                .when(StrUtil::isNotBlank)
                .perform((from, to, event, context) -> {
                    UserInfoPO userInfoPo = new UserInfoPO();
                    userInfoPo.setId(userInfoDO.getId());
                    userInfoPo.setUserStatus(from.getStatus());
                    userInfoPo.setCreateTime(LocalDateTime.now());
                    userInfoMapper.insert(userInfoPo);
                });

        StateMachine<UserStatusEnum, StatusEventEnum, String> build = machineBuilder.build(UUID.randomUUID().toString());
        build.fireEvent(UserStatusEnum.findStatus(currentStatus), StatusEventEnum.findEvent(currentStatus), "哈士奇");
    }

    /**
     * 修改用户状态为在线
     *
     * @param userInfoDO 用户详情对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeStatusToOnline(UserInfoDO userInfoDO) {
        StateMachineBuilder<UserStatusEnum, StatusEventEnum, String> machineBuilder = StateMachineBuilderFactory.create();

        Integer currentStatus = userInfoDO.getCurrentStatus();
        machineBuilder.externalTransition()
                .from(UserStatusEnum.ONLINE)
                .to(UserStatusEnum.OFFLINE)
                .on(StatusEventEnum.ONLINE_EVENT)
                .when(StrUtil::isNotBlank)
                .perform((from, to, event, context) -> {
                    UserInfoPO userInfoPo = new UserInfoPO();
                    userInfoPo.setId(userInfoDO.getId());
                    userInfoPo.setUserStatus(to.getStatus());
                    userInfoMapper.updateById(userInfoPo);
                });

        StateMachine<UserStatusEnum, StatusEventEnum, String> build = machineBuilder.build(UUID.randomUUID().toString());
        build.fireEvent(UserStatusEnum.findStatus(currentStatus), StatusEventEnum.findEvent(currentStatus), "柯基");
    }

    /**
     * 注销用户状态
     *
     * @param userInfoDO 用户详情对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelledUserStatus(UserInfoDO userInfoDO) {
        StateMachineBuilder<UserStatusEnum, StatusEventEnum, String> machineBuilder = StateMachineBuilderFactory.create();
        machineBuilder.externalTransitions()
                .fromAmong(UserStatusEnum.REGISTERED, UserStatusEnum.ONLINE, UserStatusEnum.OFFLINE)
                .to(UserStatusEnum.ACCOUNT_CANCELLED)
                .on(StatusEventEnum.CANCELLED_EVENT)
                .when(StrUtil::isNotBlank)
                .perform((from, to, event, context) -> {
                    UserInfoPO userInfoPo = new UserInfoPO();
                    userInfoPo.setId(userInfoDO.getId());
                    userInfoPo.setUserStatus(to.getStatus());
                    userInfoMapper.updateById(userInfoPo);
                });

        Integer currentStatus = userInfoDO.getCurrentStatus();
        StateMachine<UserStatusEnum, StatusEventEnum, String> build = machineBuilder.build(UUID.randomUUID().toString());
        build.fireEvent(UserStatusEnum.findStatus(currentStatus), StatusEventEnum.findEvent(currentStatus), "柴犬");
    }
}

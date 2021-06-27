package com.hanyi.cola.gatewayimpl;

import com.hanyi.cola.assembler.UserInfoAssembler;
import com.hanyi.cola.domain.UserInfoDO;
import com.hanyi.cola.gateway.UserInfoGateway;
import com.hanyi.cola.gatewayimpl.database.mapper.UserInfoMapper;
import com.hanyi.cola.gatewayimpl.database.po.UserInfoPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

package com.hanyi.cola.assembler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.hanyi.cola.domain.UserInfoDO;
import com.hanyi.cola.gatewayimpl.database.po.UserInfoPO;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户详情对象转换器
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 8:54 下午
 */
public final class UserInfoAssembler {

    private UserInfoAssembler() {
    }

    /**
     * 将领域对象转换成持久层对象
     *
     * @param userInfoDO 用户领域对象
     * @return 返回持久层对象
     */
    public static UserInfoPO toPo(UserInfoDO userInfoDO) {
        UserInfoPO userInfoPo = new UserInfoPO();
        BeanUtil.copyProperties(userInfoDO, userInfoPo);
        userInfoPo.setId(RandomUtil.randomLong(Integer.MAX_VALUE));
        userInfoPo.setCreateTime(LocalDateTime.now());

        return userInfoPo;
    }

    /**
     * 将持久层对象转换成领域对象
     *
     * @param userInfoPo 持久层对象
     * @return 返回领域对象
     */
    public static UserInfoDO toDo(UserInfoPO userInfoPo) {
        UserInfoDO userInfoDo = new UserInfoDO();
        BeanUtil.copyProperties(userInfoPo, userInfoDo);
        return userInfoDo;
    }

    /**
     * 将持久层集合转换成领域层集合
     *
     * @param userInfoPoList 用户持久层集合
     * @return 返回领域集合
     */
    public static List<UserInfoDO> toDoList(List<UserInfoPO> userInfoPoList) {
        if (CollUtil.isEmpty(userInfoPoList)) {
            return Collections.emptyList();
        }
        return userInfoPoList.stream().map(UserInfoAssembler::toDo).collect(Collectors.toList());
    }

}

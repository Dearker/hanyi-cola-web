package com.hanyi.cola.common.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * <p>
 * 状态事件枚举
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/28 10:04 下午
 */
@Getter
public enum StatusEventEnum {
    /**
     * 注册状态事件
     */
    REGISTER_EVENT(0),
    ONLINE_EVENT(1),
    CANCELLED_EVENT(3);

    /**
     * 事件的命令
     */
    private final Integer eventCommand;

    StatusEventEnum(Integer eventCommand) {
        this.eventCommand = eventCommand;
    }

    /**
     * 查询事件
     *
     * @param eventId 事件id
     * @return 对应的事件枚举
     */
    public static StatusEventEnum findEvent(Integer eventId) {
        return Stream.of(StatusEventEnum.values()).filter(s -> s.getEventCommand().equals(eventId)).findFirst().orElse(null);
    }

}

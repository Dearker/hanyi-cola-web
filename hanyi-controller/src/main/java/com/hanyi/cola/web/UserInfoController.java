package com.hanyi.cola.web;

import com.alibaba.cola.dto.SingleResponse;
import com.hanyi.cola.api.UserInfoService;
import com.hanyi.cola.dto.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户详情数据层
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/26 11:51 上午
 */
@RestController
@RequestMapping("/userInfo")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/insert")
    public void insert(@RequestBody UserInfoDTO userInfoDTO) {
        userInfoService.addUserInfoDto(userInfoDTO);
    }

    @GetMapping("/select")
    public SingleResponse<List<UserInfoDTO>> findAllUserInfoList() {
        List<UserInfoDTO> allUserInfoList = userInfoService.findAllUserInfoList();
        return SingleResponse.of(allUserInfoList);
    }

}

package com.hanyi.cola;

import com.hanyi.cola.api.UserInfoService;
import com.hanyi.cola.dto.UserInfoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/30 9:31 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Resource
    private UserInfoService userInfoService;

    @Test
    public void testSelectList(){
        System.out.println("查询出的用户数据集合：" + userInfoService.findAllUserInfoList());
    }

    @Test
    public void testSelectTotal(){
        List<UserInfoDTO> allUserInfoList = userInfoService.findAllUserInfoList();
        System.out.println("查询出用户数据的总数：" + allUserInfoList.size());
    }

}

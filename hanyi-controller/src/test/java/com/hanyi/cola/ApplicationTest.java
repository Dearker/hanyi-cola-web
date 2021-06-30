package com.hanyi.cola;

import com.alibaba.cola.test.TestsContainer;
import com.alibaba.cola.test.command.AbstractCommand;
import com.alibaba.cola.test.command.TestClassRunCmd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/30 9:11 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    /**
     * 自动调用使用带@Test或者test方法开头的所有测试方法，需要在spring环境中，详情可参考 TestExecutor 类
     */
    @Test
    public void colaTest(){
        TestsContainer.init(null);
        AbstractCommand abstractCommand = new TestClassRunCmd(UserInfoServiceTest.class.getName());
        abstractCommand.execute();
    }

}

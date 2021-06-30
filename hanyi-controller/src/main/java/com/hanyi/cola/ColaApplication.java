package com.hanyi.cola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author wenchangwei
 * @since 2021/6/27 5:00 下午
 */
@SpringBootApplication(scanBasePackages = {"com.alibaba.cola","com.hanyi.cola"})
public class ColaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColaApplication.class, args);
    }

}

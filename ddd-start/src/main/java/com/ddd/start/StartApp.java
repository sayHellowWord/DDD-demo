package com.ddd.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
@SpringBootApplication(scanBasePackages = {"com.ddd", "com.ddd.repository"})
public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }


}
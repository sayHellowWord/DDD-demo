package com.ddd.web.controller;

import com.ddd.application.TransferCmdExeService;
import com.ddd.exception.DailyLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
@RestController
public class HelloController {

    @Autowired
    private TransferCmdExeService transferCmdExeService;

    @RequestMapping("/helloWorld")
    public String index() {
        try {
            transferCmdExeService.transfer(1L, "123", BigDecimal.TEN, "USD");
        } catch (Exception e) {
            e.printStackTrace();
        } catch (DailyLimitExceededException e) {
            e.printStackTrace();
        }

        return "Hello World";
    }

}
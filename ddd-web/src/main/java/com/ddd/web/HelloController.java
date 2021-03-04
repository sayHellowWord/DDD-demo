package com.ddd.web;

import com.ddd.application.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
@RestController
public class HelloController {

    @Autowired
    private TransferService transferService;

    @RequestMapping("/helloWorld")
    public String index() {
        return "Hello World";
    }

}
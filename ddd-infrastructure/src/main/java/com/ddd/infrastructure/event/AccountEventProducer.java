package com.ddd.infrastructure.event;

import com.ddd.domains.event.AccountEvent;
import org.springframework.stereotype.Component;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Component
public class AccountEventProducer implements com.ddd.event.AccountEventProducer {

    @Override
    public void send(AccountEvent accountEvent) {
        System.out.println("发送消息: " + accountEvent.toString());

    }
}

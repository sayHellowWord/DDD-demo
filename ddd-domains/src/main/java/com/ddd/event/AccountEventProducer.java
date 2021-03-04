package com.ddd.event;

import com.ddd.domains.event.AccountEvent;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public interface AccountEventProducer {

    void send(AccountEvent accountEvent);

}

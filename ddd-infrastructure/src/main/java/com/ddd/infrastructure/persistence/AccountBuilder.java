package com.ddd.infrastructure.persistence;

import com.ddd.domains.entity.Account;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface AccountBuilder {

    Account toAccount(AccountDo accountDo);


    AccountDo fromAccount(Account account);
}

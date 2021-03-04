package com.ddd.web.dto.assembler.impl;

import com.ddd.domains.entity.Account;
import com.ddd.web.dto.AccountDto;
import com.ddd.web.dto.assembler.AccountAssembler;
import org.springframework.stereotype.Component;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Component
public class AccountAssemblerImpl implements AccountAssembler {

    @Override
    public Account toAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto fromAccount(Account account) {
        return null;
    }

}

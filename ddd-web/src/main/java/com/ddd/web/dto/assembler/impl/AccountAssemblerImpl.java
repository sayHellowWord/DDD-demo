package com.ddd.web.dto.assembler.impl;

import com.ddd.domains.entity.AccountE;
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
    public AccountE toAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto fromAccount(AccountE accountE) {
        return null;
    }

}

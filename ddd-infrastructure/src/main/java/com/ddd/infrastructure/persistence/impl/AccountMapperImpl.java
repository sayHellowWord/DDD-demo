package com.ddd.infrastructure.persistence.impl;

import com.ddd.infrastructure.persistence.AccountDO;
import com.ddd.infrastructure.persistence.AccountMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Repository
public class AccountMapperImpl implements AccountMapper {

    @Override
    public int insert(AccountDO accountDO) {
        System.err.println("------------------插入:" + accountDO);
        return 0;
    }

    @Override
    public int update(AccountDO accountDO) {
        System.err.println("------------------更新:" + accountDO);
        return 0;
    }

    @Override
    public AccountDO selectByUserId(Long id) {
        return null;
    }

    @Override
    public AccountDO selectByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public AccountDO selectById(Long id) {
        return null;
    }
}

package com.ddd.infrastructure.persistence;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface AccountMapper {

    AccountDo selectById(Long id);

    int insert(AccountDo accountDo);

    int update(AccountDo accountDo);

    AccountDo selectByAccountNumber(String accountNumber);

    AccountDo selectByUserId(Long id);

}

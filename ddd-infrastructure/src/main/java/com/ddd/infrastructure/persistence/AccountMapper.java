package com.ddd.infrastructure.persistence;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface AccountMapper {

    AccountDO selectById(Long id);

    int insert(AccountDO accountDo);

    int update(AccountDO accountDo);

    AccountDO selectByAccountNumber(String accountNumber);

    AccountDO selectByUserId(Long id);

}

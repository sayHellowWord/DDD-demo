package com.ddd.infrastructure.persistence;

import com.ddd.domains.entity.Account;

/**
 * Entity DO 转换
 * <p>
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface AccountConverter {

    /**
     * @param accountDo
     * @return
     */
    Account toAccount(AccountDO accountDo);


    /**
     * @param account
     * @return
     */
    AccountDO fromAccount(Account account);

}

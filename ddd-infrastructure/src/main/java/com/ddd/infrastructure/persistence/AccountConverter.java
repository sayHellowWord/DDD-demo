package com.ddd.infrastructure.persistence;

import com.ddd.domains.entity.AccountE;

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
    AccountE toAccount(AccountDO accountDo);


    /**
     * @param accountE
     * @return
     */
    AccountDO fromAccount(AccountE accountE);

}

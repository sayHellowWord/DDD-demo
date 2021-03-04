package com.ddd.web.dto.assembler;

import com.ddd.domains.entity.AccountE;
import com.ddd.web.dto.AccountDto;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public interface AccountAssembler {

    /**
     * @param accountDto
     * @return
     */
    AccountE toAccount(AccountDto accountDto);


    /**
     * @param accountE
     * @return
     */
    AccountDto fromAccount(AccountE accountE);

}

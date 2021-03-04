package com.ddd.repository;

import com.ddd.domains.entity.AccountE;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface AccountRepository {

    AccountE find(AccountId id);

    AccountE find(AccountNumber accountNumber);

    AccountE find(UserId userId);

    AccountE save(AccountE accountE);
}

package com.ddd.repository;

import com.ddd.domains.entity.Account;
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

    Account find(AccountId id);

    Account find(AccountNumber accountNumber);

    Account find(UserId userId);

    Account save(Account account);
}

package com.ddd.repository;

import com.ddd.domains.entity.Account;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;
import com.sun.istack.internal.NotNull;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface AccountRepository {

    Account find(@NotNull AccountId id);

    Account find(@NotNull AccountNumber accountNumber);

    Account find(@NotNull UserId userId);

    Account save(@NotNull Account account);
}

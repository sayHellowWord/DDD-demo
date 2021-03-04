package com.ddd.repository;

import com.ddd.domains.entity.Account;
import com.ddd.types.ids.AccountId;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public interface TestModuleRepository {

    Account find(AccountId id);

}

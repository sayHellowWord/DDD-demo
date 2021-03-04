package com.ddd.infrastructure.repository;

import com.ddd.domains.entity.Account;
import com.ddd.repository.TestModuleRepository;
import com.ddd.types.ids.AccountId;
import org.springframework.stereotype.Service;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Service
public class TestModuleRepositoryImpl implements TestModuleRepository {

    @Override
    public Account find(AccountId id) {
        return null;
    }
}

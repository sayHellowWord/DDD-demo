package com.ddd.infrastructure.repository;

import com.ddd.domains.entity.AccountE;
import com.ddd.infrastructure.persistence.AccountConverter;
import com.ddd.infrastructure.persistence.AccountDO;
import com.ddd.infrastructure.persistence.AccountMapper;
import com.ddd.repository.AccountRepository;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountMapper accountDao;

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public AccountE find(AccountId id) {
        AccountDO accountDo = accountDao.selectById(id.getValue());
        return accountConverter.toAccount(accountDo);
    }

    @Override
    public AccountE find(AccountNumber accountNumber) {
        AccountDO accountDo = new AccountDO();
        accountDo.setUserId(Long.valueOf(accountNumber.getValue()));
        accountDo.setAccountNumber(accountNumber.getValue());
        accountDo.setUserId(Long.valueOf(accountNumber.getValue()));
        accountDo.setAvailableAmount(new BigDecimal(555));
        accountDo.setDailyLimitAmount(new BigDecimal(100));
        accountDo.setCurrency("USD");
        return accountConverter.toAccount(accountDo);
    }

    @Override
    public AccountE find(UserId userId) {
        AccountDO accountDo = new AccountDO();
        accountDo.setUserId(userId.getValue());
        accountDo.setAccountNumber("" + userId.getValue());
        accountDo.setUserId(userId.getValue());
        accountDo.setAvailableAmount(new BigDecimal(555));
        accountDo.setDailyLimitAmount(new BigDecimal(100));
        accountDo.setCurrency("CNY");
        return accountConverter.toAccount(accountDo);
    }

    @Override
    public AccountE save(AccountE accountE) {
        AccountDO accountDo = accountConverter.fromAccount(accountE);
        if (Objects.isNull(accountDo.getId())) {
            accountDao.insert(accountDo);
        } else {
            accountDao.update(accountDo);
        }

        return accountConverter.toAccount(accountDo);
    }
}

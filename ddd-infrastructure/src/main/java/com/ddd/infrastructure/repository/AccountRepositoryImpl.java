package com.ddd.infrastructure.repository;

import com.ddd.domains.entity.Account;
import com.ddd.infrastructure.persistence.AccountBuilder;
import com.ddd.infrastructure.persistence.AccountDo;
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
    private AccountBuilder accountBuilder;

    @Override
    public Account find(AccountId id) {
        AccountDo accountDo = accountDao.selectById(id.getValue());
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDo accountDo = new AccountDo();
        accountDo.setUserId(Long.valueOf(accountNumber.getValue()));
        accountDo.setAccountNumber(accountNumber.getValue());
        accountDo.setUserId(Long.valueOf(accountNumber.getValue()));
        accountDo.setAvailableAmount(new BigDecimal(555));
        accountDo.setDailyLimitAmount(new BigDecimal(100));
        accountDo.setCurrency("USD");
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account find(UserId userId) {
        AccountDo accountDo = new AccountDo();
        accountDo.setUserId(userId.getValue());
        accountDo.setAccountNumber("" + userId.getValue());
        accountDo.setUserId(userId.getValue());
        accountDo.setAvailableAmount(new BigDecimal(555));
        accountDo.setDailyLimitAmount(new BigDecimal(100));
        accountDo.setCurrency("CNY");
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account save(Account account) {
        AccountDo accountDo = accountBuilder.fromAccount(account);
        if (Objects.isNull(accountDo.getId())) {
            accountDao.insert(accountDo);
        } else {
            accountDao.update(accountDo);
        }

        return accountBuilder.toAccount(accountDo);
    }
}

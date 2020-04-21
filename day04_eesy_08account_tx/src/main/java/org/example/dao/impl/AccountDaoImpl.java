package org.example.dao.impl;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 帳戶的持久層實現類
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("SELECT * FROM account WHERE id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty()? null:accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("SELECT * FROM account WHERE name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("結果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("UPDATE account SET name=?, money=? WHERE id=?", account.getName(), account.getMoney(), account.getId());
    }
}

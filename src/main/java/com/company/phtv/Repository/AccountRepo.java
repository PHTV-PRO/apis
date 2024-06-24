package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    Account getAccountById(int id);

    @Query("select a from Account a Where a.id = ?1")
    Account findIdAccount(int id);

    List<Account> findAccountByNameContaining( String name);
}

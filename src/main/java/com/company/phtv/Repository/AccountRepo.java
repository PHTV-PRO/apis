package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account getAccountById (int id);

    @Query("select a from Account a Where id = ?1")
    Account findIdAccount(int id);
}

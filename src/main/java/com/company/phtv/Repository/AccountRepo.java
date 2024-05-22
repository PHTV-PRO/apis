package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account getAccountById (int id);
}

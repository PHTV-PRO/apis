package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application,Integer> {
    List<Application> findByAccount(Account account);
}

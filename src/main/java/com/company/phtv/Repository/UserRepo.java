package com.company.phtv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.company.phtv.Models.Entity.Account;

public interface UserRepo extends JpaRepository<Account, Integer> {

    UserDetails findByEmail(String email);
    
}

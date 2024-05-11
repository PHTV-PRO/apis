package com.company.phtv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.company.phtv.Repository.UserRepo;
import com.company.phtv.Services.IServices.IUserService;

@Service
public class UserService  implements IUserService{
    @Autowired
    UserRepo _userRepo;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                UserDetails check = (UserDetails) _userRepo.findByEmail(username);
                return check;
            }
        };
    }
}

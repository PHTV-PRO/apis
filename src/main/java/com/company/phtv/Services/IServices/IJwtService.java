package com.company.phtv.Services.IServices;

import java.util.Map;
import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
      String generateToken(UserDetails userDetails);


    String extractUserName(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateRefreshToken(Map<String, Objects> extraClaims, UserDetails userDetails);
}

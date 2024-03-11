package com.springsecurity.jwttokencreate;

import com.springsecurity.jwttokencreate.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginResponse {
    private User user;
    private String jwtToken;
}

package com.springsecurity.jwttokencreate.controller;

import com.springsecurity.jwttokencreate.LoginResponse;
import com.springsecurity.jwttokencreate.dto.LoginRequest;
import com.springsecurity.jwttokencreate.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public LoginResponse createJwtTokenAndLogin(@RequestBody LoginRequest loginRequest) throws Exception{
        return jwtService.createJwtToken(loginRequest);
    }
}

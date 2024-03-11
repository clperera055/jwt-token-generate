package com.springsecurity.jwttokencreate.controller;

import com.springsecurity.jwttokencreate.entity.Role;
import com.springsecurity.jwttokencreate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create-new-role")
    public Role addRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }
}

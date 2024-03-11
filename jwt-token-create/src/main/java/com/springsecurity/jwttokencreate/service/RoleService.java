package com.springsecurity.jwttokencreate.service;

import com.springsecurity.jwttokencreate.entity.Role;
import com.springsecurity.jwttokencreate.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}

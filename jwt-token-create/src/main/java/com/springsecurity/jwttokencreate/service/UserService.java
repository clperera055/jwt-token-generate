package com.springsecurity.jwttokencreate.service;

import com.springsecurity.jwttokencreate.entity.Role;
import com.springsecurity.jwttokencreate.entity.User;
import com.springsecurity.jwttokencreate.repo.RoleRepo;
import com.springsecurity.jwttokencreate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {

        return userRepo.save(user);
    }

    public void initRoleAndUser(){
        Role adminRole = new Role ();
        Role userRole = new Role ();

        if(!roleRepo.existsById("Admin")){
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin Role....");
            roleRepo.save(adminRole);
        }

        if(!roleRepo.existsById("User")){
            adminRole.setRoleName("User");
            adminRole.setRoleDescription("User Role....");
            roleRepo.save(userRole);
        }

        if(!userRepo.existsById("Admin123")){
            User user = new User();
            user.setUserName("Admin123");
            user.setUserPassword(getEncodedPassword("admin@123"));
            user.setUserFirstName("Chathura");
            user.setUserLastName("Lakmal");

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);

            user.setRole(adminRoles);
            userRepo.save(user);
        }

        if(!userRepo.existsById("User123")){

            User user = new User();
            user.setUserName("User123");
            user.setUserPassword(getEncodedPassword("user@123"));
            user.setUserFirstName("Gayan");
            user.setUserLastName("Silva");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);

            user.setRole(userRoles);
            userRepo.save(user);
        }

    }

    public String getEncodedPassword(String pwd){
        return passwordEncoder.encode(pwd);
    }
}

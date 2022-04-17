package com.cs5500group10.web;

import com.cs5500group10.service.UserLoginApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserLoginApiController {

    @Autowired
    private UserLoginApiService userLoginApiService;

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam("id") String userId, @RequestParam("id") String password) {
        if (userId != null) {
            if (userLoginApiService.existsByUserId(userId)) {
                // existing user
                String savedPassword = userLoginApiService.findByUserId(userId).getPassword();
                return savedPassword.equals(password);
            } else {
                // no user found
                return false;
            }
        } else {
            return false;
        }
    }

    @PostMapping("/create_user")
    @ResponseBody
    public boolean createUser(@RequestParam("user_id") String userId, @RequestParam("password") String password) {
        if ((userId != null) && (password != null)) {
            if (userLoginApiService.existsByUserId(userId)) {
                // existing user
                return false;
            } else {
                userLoginApiService.createUser(userId, password);
                // return whether the creation succeeded
                return userLoginApiService.existsByUserId(userId);
            }
        } else {
            // creation failed
            return false;
        }
    }

    @PostMapping("/delete_user")
    @ResponseBody
    public boolean deleteUser(@RequestParam("user_id") String userId, @RequestParam("password") String password) {
        if ((userId != null) && (password != null)) {
            if (userLoginApiService.existsByUserId(userId)) {
                // existing user
                if (this.login(userId, password)) {
                    userLoginApiService.deleteByUserId(userId);
                    return !(userLoginApiService.existsByUserId(userId));
                } else {
                    // password wrong
                    return false;
                }
            } else {
                // non-existent user
                return false;
            }
        } else {
            // creation failed
            return false;
        }
    }

}

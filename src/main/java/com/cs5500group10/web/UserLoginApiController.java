package com.cs5500group10.web;

import com.cs5500group10.service.UserLoginApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api")
public class UserLoginApiController {

    @Autowired
    private UserLoginApiService userLoginApiService;

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam("user_id") String userId, @RequestParam("password") String password) {
        if (userId != null) {
            if (userLoginApiService.existsByUserId(userId)) {
                // existing user
                String savedPassword = userLoginApiService.findByUserId(userId).getPassword();
                return savedPassword.equals(password);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found!"
                );
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "A user ID must be given!"
            );
        }
    }

    @PostMapping("/create_user")
    @ResponseBody
    public boolean createUser(@RequestParam("user_id") String userId, @RequestParam("password") String password) {
        if ((userId != null) && (password != null)) {
            if (userLoginApiService.existsByUserId(userId)) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "Existing user!"
                );
            } else {
                // return whether the creation succeeded
                userLoginApiService.createUser(userId, password);
                return userLoginApiService.existsByUserId(userId);
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User ID and password must be given!"
            );
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
                    throw new ResponseStatusException(
                            HttpStatus.CONFLICT, "Wrong password!"
                    );
                }
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found!"
                );
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User ID and password must be given!"
            );
        }
    }

}

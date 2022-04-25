package com.cs5500group10.web;

import com.cs5500group10.dto.PreferenceApiDto;
import com.cs5500group10.service.PreferenceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api")
public class PreferenceApiController {

    @Autowired
    private PreferenceApiService preferenceApiService;

    @GetMapping("/get_preference/{id}")
    @ResponseBody
    public PreferenceApiDto getSavedPreferences(@PathVariable("id") String userId) {
        if (userId != null) {
            if (preferenceApiService.existsByUserId(userId)) {
                // existing user
                return preferenceApiService.findByUserId(userId);
            } else {
                // new user
                return preferenceApiService.createDefaultPreferenceApiDto(userId);
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "A user ID must be given!"
            );
        }
    }

    @PostMapping("/delete_preference")
    @ResponseBody
    public boolean deleteUser(@RequestParam("user_id") String userId) {
        if ((userId != null)) {
            if (preferenceApiService.existsByUserId(userId)) {
                preferenceApiService.deleteByUserId(userId);
                return !(preferenceApiService.existsByUserId(userId));
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found!"
                );
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "A User ID must be given!"
            );
        }
    }
}

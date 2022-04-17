package com.cs5500group10.web;

import com.cs5500group10.dto.PreferenceApiDto;
import com.cs5500group10.service.PreferenceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            // the API returns null
            return null;
        }
    }

}

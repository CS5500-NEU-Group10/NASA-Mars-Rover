package com.cs5500group10.web;

import com.cs5500group10.dto.FavoriteApiDto;
import com.cs5500group10.service.FavoriteApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api")
public class FavoriteApiController {

    @Autowired
    private FavoriteApiService favoriteApiService;

    @PostMapping("/save_favorite")
    @ResponseBody
    public boolean saveFavorites(@RequestParam("user_id") String userId, @RequestParam("data") String data) {
        if (userId != null && data != null) {
            if (favoriteApiService.existsByUserId(userId)) {
                // existing user
                favoriteApiService.deleteByUserId(userId);
            }
            favoriteApiService.createUserFavorites(userId, data);
            return favoriteApiService.existsByUserId(userId);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "The user ID and data must be given!"
            );
        }
    }

    @GetMapping("/get_favorite/{id}")
    @ResponseBody
    public FavoriteApiDto getSavedFavorites(@PathVariable("id") String userId) {
        if (userId != null) {
            if (favoriteApiService.existsByUserId(userId)) {
                // existing user
                return favoriteApiService.findByUserId(userId);
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
}

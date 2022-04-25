package com.cs5500group10.service;

import com.cs5500group10.dto.FavoriteApiDto;
import com.cs5500group10.dto.UserLoginApiDto;
import com.cs5500group10.repository.FavoriteApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteApiService {

    @Autowired
    private FavoriteApiRepository favoriteApiRepository;

    public FavoriteApiDto save(FavoriteApiDto favoriteApiDto) {
        return favoriteApiRepository.save(favoriteApiDto);
    }

    public FavoriteApiDto findByUserId(String userId) {
        return favoriteApiRepository.findByUserId(userId);
    }

    public boolean existsByUserId(String userId) {
        return favoriteApiRepository.existsByUserId(userId);
    }

    public int deleteByUserId(String userId) {
        return favoriteApiRepository.deleteByUserId(userId);
    }

    public FavoriteApiDto createUserFavorites(String userId, String data) {
        FavoriteApiDto favoriteApiDto = new FavoriteApiDto();
        favoriteApiDto.setUserId(userId);
        favoriteApiDto.setData(data);
        this.save(favoriteApiDto);
        return favoriteApiDto;
    }
}

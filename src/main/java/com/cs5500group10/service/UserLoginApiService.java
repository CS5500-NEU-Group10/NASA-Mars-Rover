package com.cs5500group10.service;

import com.cs5500group10.dto.UserLoginApiDto;
import com.cs5500group10.repository.UserLoginApiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserLoginApiService {
    @Autowired
    public UserLoginApiRepository userLoginApiRepository;

    public UserLoginApiDto save(UserLoginApiDto userLoginApiDto) {
        return userLoginApiRepository.save(userLoginApiDto);
    }

    public UserLoginApiDto findByUserId(String userId) {
        return userLoginApiRepository.findByUserId(userId);
    }

    public boolean existsByUserId(String userId) {
        return userLoginApiRepository.existsByUserId(userId);
    }

    public int deleteByUserId(String userId) {
        return userLoginApiRepository.deleteByUserId(userId);
    }

    public UserLoginApiDto createUser(String userId, String password) {
        UserLoginApiDto userLoginApiDto = new UserLoginApiDto();
        userLoginApiDto.setUserId(userId);
        userLoginApiDto.setPassword(password);
        this.save(userLoginApiDto);
        return userLoginApiDto;
    }
}

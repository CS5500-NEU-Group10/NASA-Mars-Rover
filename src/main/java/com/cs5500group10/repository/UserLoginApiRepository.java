package com.cs5500group10.repository;

import com.cs5500group10.dto.UserLoginApiDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginApiRepository extends JpaRepository<UserLoginApiDto, String> {

    UserLoginApiDto findByUserId(String userId);

    boolean existsByUserId(String userId);

    int deleteByUserId(String userId);
}

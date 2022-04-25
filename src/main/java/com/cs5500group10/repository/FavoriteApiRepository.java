package com.cs5500group10.repository;

import com.cs5500group10.dto.FavoriteApiDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteApiRepository extends JpaRepository<FavoriteApiDto, String> {

    FavoriteApiDto findByUserId(String userId);

    boolean existsByUserId(String userId);

    int deleteByUserId(String userId);
}

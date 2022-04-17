package com.cs5500group10.repository;

import com.cs5500group10.dto.PreferenceApiDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceApiRepository extends JpaRepository<PreferenceApiDto, String> {

    PreferenceApiDto findByUserId(String userId);

    boolean existsByUserId(String userId);

    int deleteByUserId(String userId);
}

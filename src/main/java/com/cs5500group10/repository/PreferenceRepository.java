package com.cs5500group10.repository;

import com.cs5500group10.dto.PreferenceDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<PreferenceDto, Long> {

    PreferenceDto findByUserId(Long userId);

}

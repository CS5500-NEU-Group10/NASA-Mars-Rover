package com.cs5500group10.service;

import com.cs5500group10.dto.PreferenceApiDto;
import com.cs5500group10.repository.PreferenceApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceApiService {

    @Autowired
    private PreferenceApiRepository preferencesApiRepository;

    public PreferenceApiDto save(PreferenceApiDto preferenceApiDto) {
        return preferencesApiRepository.save(preferenceApiDto);
    }

    public PreferenceApiDto findByUserId(String userId) {
        return preferencesApiRepository.findByUserId(userId);
    }

    public boolean existsByUserId(String userId) {
        return preferencesApiRepository.existsByUserId(userId);
    }

    public int deleteByUserId(String userId) {
        return preferencesApiRepository.deleteByUserId(userId);
    }

    // create default preference when the user is not found in database
    public PreferenceApiDto createDefaultPreferenceApiDto(String userId) {
        PreferenceApiDto preferenceApiDto = new PreferenceApiDto();
        preferenceApiDto.setMarsApiRoverData("Opportunity");
        preferenceApiDto.setMarsSol(1);
        preferenceApiDto.setUserId(userId);

        // assign false to all options
        preferenceApiDto.setCameraChemcam(false);
        preferenceApiDto.setCameraFhaz(false);
        preferenceApiDto.setCameraMahli(false);
        preferenceApiDto.setCameraMardi(false);
        preferenceApiDto.setCameraMast(false);
        preferenceApiDto.setCameraMinites(false);
        preferenceApiDto.setCameraNavcam(false);
        preferenceApiDto.setCameraPancam(false);
        preferenceApiDto.setCameraRhaz(false);

        this.save(preferenceApiDto);
        return preferenceApiDto;
    }
}

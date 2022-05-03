package com.cs5500group10.web;

import com.cs5500group10.dto.PreferenceDto;
import com.cs5500group10.response.MarsRoverApiResponse;
import com.cs5500group10.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView(ModelMap model, Long userId, Boolean createUser) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PreferenceDto preferenceDto = createDefaultPreferenceDto(userId);

        if (Boolean.TRUE.equals(createUser) && userId == null) {
            preferenceDto = roverService.save(preferenceDto);
        } else {
            preferenceDto = roverService.findByUserId(userId);
            if (preferenceDto == null) {
                preferenceDto = createDefaultPreferenceDto(userId);
            }
        }

        MarsRoverApiResponse roverData = roverService.getRoverData(preferenceDto);
        model.put("roverData", roverData);
        model.put("preferenceDto", preferenceDto);
        model.put("validCameras", roverService.getValidCameras().get(preferenceDto.getMarsApiRoverData()));
        if (!Boolean.TRUE.equals(preferenceDto.getRememberPreferences()) && userId != null) {
            PreferenceDto defaultPreferenceDto = createDefaultPreferenceDto(userId);
            roverService.save(defaultPreferenceDto);
        }

        return "index";
    }

    @GetMapping("/savedPreferences")
    @ResponseBody
    public PreferenceDto getSavedPreferences(Long userId) {
        if (userId != null)
            return roverService.findByUserId(userId);
        else
            return createDefaultPreferenceDto(userId);
    }

    private PreferenceDto createDefaultPreferenceDto(Long userId) {
        PreferenceDto preferenceDto = new PreferenceDto();
        preferenceDto.setMarsApiRoverData("Opportunity");
        preferenceDto.setMarsSol(1);
        preferenceDto.setUserId(userId);
        return preferenceDto;
    }

    @PostMapping("/")
    public String postHomeView(PreferenceDto preferenceDto) {
        preferenceDto = roverService.save(preferenceDto);
        return "redirect:/?userId=" + preferenceDto.getUserId();
    }

}

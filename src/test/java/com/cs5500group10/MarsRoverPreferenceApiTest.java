package com.cs5500group10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cs5500group10.dto.PreferenceApiDto;
import com.cs5500group10.repository.PreferenceApiRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MarsRoverPreferenceApiTest {

	@Autowired private PreferenceApiRepository repo;
	
	@Test
    public void testCreateUserPreference() {

		PreferenceApiDto preferenceApiDto = new PreferenceApiDto();
        preferenceApiDto.setMarsApiRoverData("Opportunity");
        preferenceApiDto.setMarsSol(1);
        preferenceApiDto.setUserId("1");

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
		
        repo.save(preferenceApiDto);

        assertTrue(repo.existsByUserId(preferenceApiDto.getUserId()));
    }
	

    @Test
    public void testFindUserPreferenceById() {
    	PreferenceApiDto preferenceApiDto = repo.findByUserId("2");
        assertThat(preferenceApiDto).isNull();
    }

    @Test
    public void testDeleteUserPreferenceById() {
        String userId = "1";
        assertThat(repo.deleteByUserId(userId)).isGreaterThan(0);
    }
}

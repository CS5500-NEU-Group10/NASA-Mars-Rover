package com.cs5500group10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cs5500group10.dto.FavoriteApiDto;
import com.cs5500group10.repository.FavoriteApiRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MarsRoverFavoriteApiTest {

	@Autowired private FavoriteApiRepository repo;
	
	@Test
    public void testCreateUserFavorite() {
		FavoriteApiDto favoriteApiDto = new FavoriteApiDto();
		favoriteApiDto.setUserId("1");
		favoriteApiDto.setData("favorite");

        repo.save(favoriteApiDto);

        assertTrue(repo.existsByUserId(favoriteApiDto.getUserId()));
    }
	

    @Test
    public void testFindUserFavoriteById() {
    	FavoriteApiDto favoriteApiDto = repo.findByUserId("1");
        assertThat(favoriteApiDto).isNotNull();
    }

    @Test
    public void testDeleteUserFavoriteById() {
        String userId = "1";
        assertThat(repo.deleteByUserId(userId)).isGreaterThan(0);
    }
}

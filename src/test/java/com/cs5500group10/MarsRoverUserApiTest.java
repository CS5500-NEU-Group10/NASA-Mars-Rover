package com.cs5500group10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cs5500group10.dto.UserLoginApiDto;
import com.cs5500group10.repository.UserLoginApiRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MarsRoverUserApiTest {
	
	@Autowired private UserLoginApiRepository repo;

    @Test
    public void testCreateNewUser() {
        UserLoginApiDto savedUser = new UserLoginApiDto();
        savedUser.setUserId("1");
        savedUser.setPassword("password");

        repo.save(savedUser);

        assertTrue(repo.existsByUserId(savedUser.getUserId()));
    }

    @Test
    public void testFindUserById() {
        UserLoginApiDto savedUser = repo.findByUserId("1");
        assertThat(savedUser).isNotNull();
    }

    @Test
    public void testDeleteUser() {
        String userId = "1";
        assertThat(repo.deleteByUserId(userId)).isGreaterThan(0);
    }
}

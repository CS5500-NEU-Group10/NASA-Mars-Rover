package com.cs5500group10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.cs5500group10.dto.UserLoginApiDto;
import com.cs5500group10.repository.UserLoginApiRepository;
import com.cs5500group10.service.UserLoginApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MarsRoverUserTest {
    @Autowired
    private UserLoginApiService service = new UserLoginApiService();

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateNewUser() {
        UserLoginApiDto savedUser = new UserLoginApiDto();
        savedUser.setUserId("1");
        savedUser.setPassword("password");

        service.save(savedUser);

        assertTrue(service.existsByUserId(savedUser.getUserId()));
    }

    @Test
    public void testexistsUserById() {
        UserLoginApiDto savedUser = service.findByUserId("1");
        assertThat(savedUser).isNotNull();
    }

    @Test
    public void testDeleteUser() {
        String userId = "1";
        assertThat(service.deleteByUserId(userId)).isGreaterThan(0);
    }
}

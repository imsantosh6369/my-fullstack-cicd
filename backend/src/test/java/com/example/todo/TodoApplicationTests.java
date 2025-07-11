package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
class TodoApplicationTests {

    @Test
    void contextLoads() {
        // Simple test to ensure Spring context loads
        assert true;
    }
}
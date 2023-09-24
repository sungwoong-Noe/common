package com.example.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Test
    @WithMockUser(username = "test12",roles= {"USER"}, password = "1234")
    @DisplayName("로그인 요청 테스트")
    void test1(){
    }
}
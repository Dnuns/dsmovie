package com.devsuperior.dsmovie.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void scoresShouldThrowClientError() throws Exception {

        mockMvc.perform(put("/api/v1/scores"))
                .andExpect(status().is4xxClientError());
    }
}
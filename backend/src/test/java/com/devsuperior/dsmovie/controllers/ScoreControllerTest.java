package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ScoreService scoreService;


    @Test
    void scoresShouldThrowClientError() throws Exception {

        mockMvc.perform(put("/scores"))
                .andExpect(status().is4xxClientError());
    }
}
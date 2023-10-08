package com.devsuperior.dsmovie.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void findAllShouldReturnPageOfMovieDto() throws Exception {

        mockMvc.perform(get("/movies"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.content..id").value(1))
            .andExpect(jsonPath("$.content..title").value("O Rei Macaco"))
            .andExpect(jsonPath("$.content..score").value(0.0))
            .andExpect(jsonPath("$.content..count").value(1))
            .andExpect(jsonPath("$.content..image").value("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bmwK5QCznqUT8bcDR7qROrxqgov.jpg"));
    }

    @Test
    void findByIdShouldReturnMovieDtoWhenIdExists() throws Exception {
        mockMvc.perform(get("/movies/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("O Rei Macaco"))
                .andExpect(jsonPath("$.score").value(0.0))
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.image").value("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bmwK5QCznqUT8bcDR7qROrxqgov.jpg"));
    }

}
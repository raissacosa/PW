package com.example.demo.controller;

import com.example.demo.model.Joaca;
import com.example.demo.service.JoacaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = JoacaController.class)
public class JoacaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JoacaService joacaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getJoacaHappyFlow() throws Exception{

        Joaca joaca = new Joaca(1,1500,1,1);
        when(joacaService.getJoaca()).thenReturn(
                Arrays.asList(new Joaca(1,1500,1,1))
        );

        mockMvc.perform(get("/joaca/get")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(Arrays.asList(new Joaca(1,1500,1,1)))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].salariu").value(joaca.getSalariu()));

    }

    @Test
    public void addJoacaHappyFlow() throws Exception{
        Joaca joaca = new Joaca(1,1500,1,1);
        when(joacaService.addJoaca(any())).thenReturn(joaca);

        mockMvc.perform(
                post("/joaca/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(joaca))
        ).andExpect(jsonPath("$.salariu").value(joaca.getSalariu()));

    }

    @Test
    public void deleteJoacaHappyFlow() throws Exception{
        Joaca joaca = new Joaca(1,1500,1,1);

        when(joacaService.deleteJoacaById(1)).thenReturn(List.of());

        mockMvc.perform(delete("/joaca/delete?id=" + joaca.getIdJoaca())
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(joaca)))
                .andExpect(status().isOk());
    }

}

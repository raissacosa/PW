package com.example.demo.controller;


import com.example.demo.model.Gen;
import com.example.demo.service.GenService;
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


@WebMvcTest(controllers = GenController.class)
public class GenControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenService genService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addGenHappyFlow() throws Exception{
        Gen gen = new Gen(1,"Comedie");
        when(genService.addGen(any())).thenReturn(gen);

        mockMvc.perform(
                post("/gen/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(gen))
        ).andExpect(jsonPath("$.numeGen").value(gen.getNumeGen()));


    }

    @Test
    public void getGenHappyFlow() throws Exception{
        Gen gen = new Gen(1,"Comedie");

        when(genService.getGen()).thenReturn(
                Arrays.asList( new Gen(1,"Comedie"))
        );

        mockMvc.perform(get("/gen/get")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(Arrays.asList( new Gen(1,"Comedie")))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeGen").value(gen.getNumeGen()));


    }

    @Test
    public void deleteGenHappyFlow() throws Exception{
        Gen gen = new Gen(1,"Comedie");
        List<Gen> result = List.of(gen);

        when(genService.deleteGen(1)).thenReturn(List.of());

        mockMvc.perform(delete("/gen/delete?id=" + gen.getIdGen())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(gen)))
                .andExpect(status().isOk());



    }

}

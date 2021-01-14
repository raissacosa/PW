package com.example.demo.controller;


import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
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

@WebMvcTest(controllers = ActorController.class)
public class ActorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getActorHappyFlow() throws Exception{



        when(actorService.getActori()).thenReturn(Arrays.asList(new Actor(1,"Roberts","Julia")));

        mockMvc.perform(get("/actor/get")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(Arrays.asList(new Actor(1,"Roberts","Julia")))))
                .andExpect(status().isOk());

    }

    @Test
    public  void addActorHappyFlow() throws Exception{
        Actor actor = new Actor(1,"Roberts","Julia");

        when(actorService.addActor(any())).thenReturn(actor);

        mockMvc.perform(post("/actor/add")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(actor)))
                .andExpect(jsonPath("$.numeActor").value(actor.getNumeActor()));

    }

    @Test
    public void deleteActorHappyFlow() throws Exception{

        Actor actor = new Actor(1,"Roberts","Julia");

        when(actorService.deleteActorById(1)).thenReturn(List.of());

        mockMvc.perform(delete("/actor/delete?id=" + actor.getIdActor())
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(actor)))
                .andExpect(status().isOk());

    }

    @Test
    public void getActorByNameHappyFlow() throws Exception{

        Actor actor = new Actor(1,"Roberts","Julia");
        when(actorService.getActorByName("Roberts")).thenReturn(Arrays.asList(new Actor(1,"Roberts","Julia")));

        mockMvc.perform(get("/actor/getbynume?numeActor=" +actor.getNumeActor() )
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(Arrays.asList(new Actor(1,"Roberts","Julia")))))
                .andExpect(status().isOk());


    }
}

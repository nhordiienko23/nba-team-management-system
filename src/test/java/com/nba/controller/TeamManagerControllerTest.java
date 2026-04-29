package com.nba.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nba.dto.StaffDto;
import com.nba.model.Position;
import com.nba.service.TeamManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TeamManagerController.class)
public class TeamManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamManager teamManager;

    @Autowired
    private ObjectMapper objectMapper;

    // --- CRUD OPERATIONS ---

    @Test
    void addStaff_ShouldWork() throws Exception {
        mockMvc.perform(post("/api/staff/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"player\", \"name\":\"Jordan\", \"baseSalary\":1000}"))
                .andExpect(status().isOk());
    }

    @Test
    void updateStaff_ShouldWork() throws Exception {
        mockMvc.perform(put("/api/staff/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"player\", \"name\":\"NewName\", \"baseSalary\":1000}"))
                .andExpect(status().isOk());
    }

    @Test
    void patchStaff_ShouldWork() throws Exception {
        mockMvc.perform(patch("/api/staff/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"PatchedName\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void getStaffById_ShouldWork() throws Exception {
        mockMvc.perform(get("/api/staff/1")).andExpect(status().isOk());
    }

    @Test
    void deleteStaff_ShouldWork() throws Exception {
        mockMvc.perform(delete("/api/staff/1")).andExpect(status().isOk());
    }

    // --- GET LISTS / FILTERING ---

    @Test
    void getAllStaff_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/staff?page=0&size=20")).andExpect(status().isOk());
    }

    @Test
    void getAllPlayers_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/players")).andExpect(status().isOk());
    }

    @Test
    void getAllCoaches_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/coaches")).andExpect(status().isOk());
    }

    @Test
    void getHighestPaid_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/highest-paid")).andExpect(status().isOk());
    }

    @Test
    void getHighestRating_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/highest-rating")).andExpect(status().isOk());
    }

    @Test
    void getPlayersByBonus_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/players/bonus?minBonus=100")).andExpect(status().isOk());
    }

    @Test
    void getStaffByBaseSalary_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/staff/base-salary?minBaseSalary=1000")).andExpect(status().isOk());
    }

    @Test
    void getByName_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/staff/name?name=Jordan")).andExpect(status().isOk());
    }

    @Test
    void getCoachesByExperience_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/coaches/experience-year?minExperienceYear=5")).andExpect(status().isOk());
    }

    @Test
    void getCoachesByChampionship_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/coaches/championship-won?minChampionshipWon=1")).andExpect(status().isOk());
    }

    @Test
    void getPlayersByPositions_ShouldReturnPage() throws Exception {
        mockMvc.perform(get("/api/players/positions?position=PG")).andExpect(status().isOk());
    }
}
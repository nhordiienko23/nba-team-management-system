package com.nba.controller;

import com.nba.model.Player;
import com.nba.model.Position;
import com.nba.service.TeamManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlayerController {
    private final TeamManager teamManager;

    public PlayerController(TeamManager teamManager) {
        this.teamManager = teamManager;
        teamManager.addStaff(new Player("Michael Jordan", 1000000, 99, Position.SG, Position.SF));
        //teamManager.addStaff(new Player("Scottie Pippen", 700000, 92, Position.SF, Position.PF));
        //teamManager.addStaff(new Player("Dennis Rodman", 500000, 88, Position.PF, Position.C));
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return teamManager.getPlayers();
    }
}
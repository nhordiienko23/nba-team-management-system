package com.nba.dto;

import com.nba.model.Position;

import java.util.List;

public class StaffDto {
    public String type; // "player" or "coach"
    public String name;
    public double baseSalary;

    // fields for player
    public Integer rating;
    public List<Position> positions;

    // fields for coach
    public Integer experienceYears;
    public Integer championshipsWon;


}

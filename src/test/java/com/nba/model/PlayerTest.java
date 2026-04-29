package com.nba.model;

import com.nba.exception.InvalidStaffDataException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void calculateBonus_HighRating_Returns20Percent() {
        Player player = new Player("Star", 1000, 95, Position.PG);
        assertEquals(200.0, player.calculateBonus());
    }

    @Test
    void calculateBonus_LowRating_ReturnsZero() {
        Player player = new Player("Bench", 1000, 80, Position.PG);
        assertEquals(0.0, player.calculateBonus());
    }

    @Test
    void constructor_InvalidRating_ThrowsException() {
        assertThrows(InvalidStaffDataException.class, () ->
                new Player("Bad", 1000, 150, Position.PG));
    }
}
package com.nba.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoachTest {

    @Test
    void calculateBonus_FormulaIsCorrect() {
        // Salary 1000, Exp 2 years (1000*2*0.05 = 100), Champ 1 (50000)
        // Bonus = 100 + 50000 = 50100
        Coach coach = new Coach("Coach", 1000, 2, 1);
        assertEquals(50100.0, coach.calculateBonus());
    }
}
package com.nba.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {

    @Test
    void calculateTotalSalary_IncludesBonus() {
        Staff staff = new Staff("Tester", 1000) {
            @Override
            public double calculateBonus() { return 500; }
        };

        assertEquals(1500.0, staff.calculateTotalSalary());
        assertEquals(285.0, staff.calculateTax()); // 1500 * 0.19
    }
}
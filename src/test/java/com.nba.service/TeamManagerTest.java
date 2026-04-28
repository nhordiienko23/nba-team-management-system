package com.nba.service;

import com.nba.exception.StaffNotFoundException;
import com.nba.model.Player;
import com.nba.model.Position;
import com.nba.model.Staff;
import com.nba.repository.StaffRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeamManagerTest {

    @Mock
    private StaffRepository staffRepository;

    @InjectMocks
    private TeamManager teamManager;

    @Test
    void getStaffById_ShouldReturnStaff_WhenExists() {
        Player mockPlayer = new Player("LeBron James", 900000, 98, Position.SF);
        when(staffRepository.findById(1)).thenReturn(Optional.of(mockPlayer));

        Staff result = teamManager.getStaffById(1);

        assertNotNull(result);
        assertEquals("LeBron James", result.getName());
        verify(staffRepository, times(1)).findById(1);
    }

    @Test
    void getStaffById_ShouldThrowException_WhenNotFound() {
        when(staffRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(StaffNotFoundException.class, () -> teamManager.getStaffById(99));
    }
}
package com.nba.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AuditLogTest {

    @Test
    void auditLogConstructor_ShouldSetTimestamp() {
        AuditLog log = new AuditLog("testMethod", "arg1, arg2");

        assertEquals("testMethod", log.getMethodName());
        assertEquals("arg1, arg2", log.getArguments());
        assertNotNull(log.getTimestamp());
        assertTrue(log.getTimestamp().isBefore(LocalDateTime.now().plusSeconds(1)));
    }
}
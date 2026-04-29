package com.nba.aspect;

import com.nba.model.AuditLog;
import com.nba.repository.AuditLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoggingAspectTest {

    @Mock
    private AuditLogRepository auditLogRepository;

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private Signature signature;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @Test
    void logAfterSuccess_ShouldSaveAuditLog() {
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("addStaff");
        when(joinPoint.getArgs()).thenReturn(new Object[]{"some argument"});

        loggingAspect.logAfterSuccess(joinPoint);

        verify(auditLogRepository, times(1)).save(any(AuditLog.class));
    }
}
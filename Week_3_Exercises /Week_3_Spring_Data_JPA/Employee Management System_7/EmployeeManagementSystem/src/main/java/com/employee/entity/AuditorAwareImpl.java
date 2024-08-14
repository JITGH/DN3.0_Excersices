package com.employee.entity;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the current user; here, just returning a static value for simplicity
        return Optional.of("Admin");
    }
}

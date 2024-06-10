package com.example.multisourcerepositoryapp.common.persistence;

import org.springframework.data.domain.AuditorAware;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditableEntityCallback implements BeforeSaveCallback<AuditableEntity> {
    private final AuditorAware<String> auditorAware;

    public AuditableEntityCallback(AuditorAware<String> auditorAware) {
        this.auditorAware = auditorAware;
    }

    @Override
    public AuditableEntity onBeforeSave(AuditableEntity entity,
                                        MutableAggregateChange<AuditableEntity> entityChange) {

        String currentAuditor = auditorAware.getCurrentAuditor().orElse("system");
        LocalDateTime now = LocalDateTime.now();

        if (entity.getCreatedDate() == null) {
            entity.setCreatedBy(currentAuditor);
            entity.setCreatedDate(now.toString());
        }

        entity.setLastModifiedBy(currentAuditor);
        entity.setLastModifiedDate(now.toString());

        return entity;
    }
}

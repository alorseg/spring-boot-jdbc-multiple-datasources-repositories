package com.example.multisourcerepositoryapp.common.persistence;

import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

@Component
public class AuditableEntityCallback implements BeforeSaveCallback<AuditableEntity> {

    @Override
    public AuditableEntity onBeforeSave(AuditableEntity aggregate, MutableAggregateChange<AuditableEntity> aggregateChange) {
        int i = 5;

        return null;
    }
}

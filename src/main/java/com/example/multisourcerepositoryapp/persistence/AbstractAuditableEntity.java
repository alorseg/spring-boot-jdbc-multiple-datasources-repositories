package com.example.multisourcerepositoryapp.persistence;

import java.time.LocalDateTime;

public abstract class AbstractAuditableEntity implements AuditableEntity {
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public void setCreatedDate(String createdDate) {
        this.createdDate = LocalDateTime.parse(createdDate);
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = LocalDateTime.parse(lastModifiedDate);
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public String getCreatedDate() {
        return createdDate != null ? createdDate.toString() : null;
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public String getLastModifiedDate() {
        return lastModifiedDate != null ? lastModifiedDate.toString() : null;
    }

}

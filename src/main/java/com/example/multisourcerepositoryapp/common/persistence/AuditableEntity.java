package com.example.multisourcerepositoryapp.common.persistence;


public interface AuditableEntity {
    void setCreatedBy(String createdBy);

    void setCreatedDate(String createdDate);

    void setLastModifiedBy(String lastModifiedBy);

    void setLastModifiedDate(String lastModifiedDate);

    String getCreatedBy();

    String getCreatedDate();

    String getLastModifiedBy();

    String getLastModifiedDate();
}

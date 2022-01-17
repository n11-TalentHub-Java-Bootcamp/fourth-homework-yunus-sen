package com.yunussen.debtpaymentws.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PreUpdate
    public void onPreUpdate() {
        updatedAt=new Date();
    }

    @PrePersist
    public void onPrePersist() {
        createdAt=new Date();
    }
}
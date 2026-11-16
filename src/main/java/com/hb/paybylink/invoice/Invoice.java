package com.hb.paybylink.invoice;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    private String amount;
    private String invoiceName;
    private String phoneNumber;
    private String email;
    private String note;
    private String currency;
    private String status;
    private LocalDateTime expiredDate;

    public Invoice(UUID id, String amount, String invoiceName, String phoneNumber, String email, String note,
            String currency,
            String status, LocalDateTime expiredDate) {
        this.id = id;
        this.amount = amount;
        this.invoiceName = invoiceName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.note = note;
        this.currency = currency;
        this.status = status;
        this.expiredDate = expiredDate;
    }

}

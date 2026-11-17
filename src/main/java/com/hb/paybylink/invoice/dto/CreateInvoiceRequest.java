package com.hb.paybylink.invoice.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Currency;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvoiceRequest {
    @NotBlank
    private String invoiceName;
    @NotNull
    @Positive
    private Double amount;
    private String phoneNumber;
    @Email
    private String email;
    private String note;
    @Currency(value = { "ETB" })
    private String currency;
    @Future
    private LocalDateTime expiredDate;

}

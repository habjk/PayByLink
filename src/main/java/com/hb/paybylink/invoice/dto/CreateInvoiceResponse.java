package com.hb.paybylink.invoice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvoiceResponse {
    private String id;
    private Double amount;
    private String invoiceName;
    private String phoneNumber;
    private String email;
    private String note;
    private String currency;
    private String status;
    private String expiredDate;

    public CreateInvoiceResponse(String id, Double amount, String invoiceName, String phoneNumber, String email,
            String note, String currency, String status, String expiredDate) {
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

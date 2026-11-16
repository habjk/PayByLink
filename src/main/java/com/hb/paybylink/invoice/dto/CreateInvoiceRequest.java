package com.hb.paybylink.invoice.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvoiceRequest {
    private String invoiceName;
    private String amount;
    private String phoneNumber;
    private String email;
    private String note;
    private String currency;
    private String status;
    private LocalDateTime expiredDate;

}

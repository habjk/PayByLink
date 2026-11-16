package com.hb.paybylink.invoice;

import org.springframework.web.bind.annotation.RestController;

import com.hb.paybylink.invoice.dto.CreateInvoiceRequest;
import com.hb.paybylink.invoice.dto.CreateInvoiceResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("linkpay/create-invoice")
    public CreateInvoiceResponse createInvoice(@RequestBody CreateInvoiceRequest request) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceName(request.getInvoiceName());
        invoice.setAmount(request.getAmount());
        invoice.setPhoneNumber(request.getPhoneNumber());
        invoice.setEmail(request.getEmail());
        invoice.setNote(request.getNote());
        invoice.setCurrency(request.getCurrency());
        invoice.setStatus(request.getStatus());
        invoice.setExpiredDate(request.getExpiredDate());
        invoiceService.createInvoice(invoice);
        return new CreateInvoiceResponse(invoice.getId().toString(), invoice.getInvoiceName(), invoice.getAmount(),
                invoice.getPhoneNumber(), invoice.getEmail(), invoice.getNote(), invoice.getCurrency(),
                invoice.getStatus(), invoice.getExpiredDate().toString());
    }
}

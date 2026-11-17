package com.hb.paybylink.invoice;

import org.springframework.web.bind.annotation.RestController;

import com.hb.paybylink.invoice.dto.CreateInvoiceRequest;
import com.hb.paybylink.invoice.dto.CreateInvoiceResponse;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        invoice.setExpiredDate(request.getExpiredDate());
        invoice = invoiceService.createInvoice(invoice);
        return new CreateInvoiceResponse(invoice.getId().toString(), invoice.getAmount(), invoice.getInvoiceName(),
                invoice.getPhoneNumber(), invoice.getEmail(), invoice.getNote(), invoice.getCurrency(),
                invoice.getStatus(), invoice.getExpiredDate().toString());
    }

    public ResponseEntity<?> updateInvoice(@PathVariable String id, @RequestBody CreateInvoiceRequest request) {
        CreateInvoiceResponse updatedInvoice = invoiceService.updateInvoice(UUID.fromString(id),
                new Invoice(UUID.fromString(id), request.getAmount(), request.getInvoiceName(),
                        request.getPhoneNumber(), request.getEmail(), request.getNote(), request.getCurrency(), null,
                        request.getExpiredDate()));
        if (updatedInvoice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedInvoice);
    }

    @GetMapping("linkpay/get-invoice/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable String id) {
        Invoice invoice = invoiceService.getInvoiceById(UUID.fromString(id));
        if (invoice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CreateInvoiceResponse(invoice.getId().toString(), invoice.getAmount(),
                invoice.getInvoiceName(), invoice.getPhoneNumber(), invoice.getEmail(), invoice.getNote(),
                invoice.getCurrency(), invoice.getStatus(), invoice.getExpiredDate().toString()));
    }
}

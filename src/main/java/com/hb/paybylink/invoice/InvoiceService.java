package com.hb.paybylink.invoice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hb.paybylink.invoice.dto.CreateInvoiceResponse;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(UUID id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public CreateInvoiceResponse updateInvoice(UUID id, Invoice updatedInvoice) {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        existingInvoice.setInvoiceName(updatedInvoice.getInvoiceName());
        existingInvoice.setAmount(updatedInvoice.getAmount());
        existingInvoice.setPhoneNumber(updatedInvoice.getPhoneNumber());
        existingInvoice.setEmail(updatedInvoice.getEmail());
        existingInvoice.setNote(updatedInvoice.getNote());
        existingInvoice.setCurrency(updatedInvoice.getCurrency());
        existingInvoice.setStatus(updatedInvoice.getStatus());
        existingInvoice.setExpiredDate(updatedInvoice.getExpiredDate());
        updatedInvoice = invoiceRepository.save(existingInvoice);
        return new CreateInvoiceResponse(updatedInvoice.getId().toString(), updatedInvoice.getAmount(),
                updatedInvoice.getInvoiceName(), updatedInvoice.getPhoneNumber(), updatedInvoice.getEmail(),
                updatedInvoice.getNote(), updatedInvoice.getCurrency(), updatedInvoice.getStatus(),
                updatedInvoice.getExpiredDate().toString());

    }

}

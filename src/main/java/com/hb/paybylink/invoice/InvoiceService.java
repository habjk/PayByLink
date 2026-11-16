package com.hb.paybylink.invoice;

import java.util.UUID;

import org.springframework.stereotype.Service;

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

}

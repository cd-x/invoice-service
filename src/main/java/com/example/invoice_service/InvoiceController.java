package com.example.invoice_service;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final Invoice invoice1 = new Invoice(1, 3, 32.6);
    private final Invoice invoice2 = new Invoice(2, 4, 459.0);

    @GetMapping
    public List<Invoice> getInvoices(){
        return List.of(invoice1, invoice2);
    }

    @GetMapping("/{id}")
    @ExceptionHandler(value = BadRequestException.class)
    public Invoice getInvoiceById(@PathVariable int id) throws BadRequestException {
        if(id == 1) return invoice1;
        else if (id == 2) return invoice2;
        else throw new BadRequestException("invalid invoice id");
    }

}

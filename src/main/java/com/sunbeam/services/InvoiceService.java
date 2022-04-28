package com.sunbeam.services;

import com.sunbeam.entities.Invoice;

public interface InvoiceService {

	String addInvoice(Invoice invoice, int aid);

	Invoice findInvoiceDetailsByAppointment(int aid);
	
}

package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Invoice;
import com.sunbeam.services.InvoiceServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceServiceImpl iService;

	@PostMapping("/add/{aid}")
	public ResponseEntity<?> addinvoice(@RequestBody Invoice invoice, @PathVariable("aid") int aid) {
		System.out.println(invoice);
		try {
			return new ResponseEntity<>(iService.addInvoice(invoice, aid), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{aid}")
	public ResponseEntity<Invoice> findInvoiceDetailsByAppointment(@PathVariable int aid) {
		Invoice list = iService.findInvoiceDetailsByAppointment(aid);
		if (list == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(list);
	}
}

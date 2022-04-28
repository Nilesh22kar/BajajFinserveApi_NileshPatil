package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Invoice;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, Integer> {

}

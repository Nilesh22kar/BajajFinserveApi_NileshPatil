package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Staff;

@Repository
public interface StaffDao extends JpaRepository<Staff, Integer> {

	Staff findBySname(String name);

}

package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Automobile;

@Repository
public interface AutomobileDao extends JpaRepository<Automobile, Integer> {
	
	public Automobile findAutomobileById(int id);

}

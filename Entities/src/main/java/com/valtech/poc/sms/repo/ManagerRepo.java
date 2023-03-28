package com.valtech.poc.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.poc.sms.entities.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer>{


}

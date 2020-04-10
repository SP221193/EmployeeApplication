package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	@Query(value = "select mgr from Manager mgr")
	List<Manager> getManagers();
	
	@Query(value = "select mgr from Manager mgr where mgr.email = :emailID and mgr.password = :pass")
	Manager Validate(@Param("emailID") String emailID,@Param("pass") String pass);
	
}

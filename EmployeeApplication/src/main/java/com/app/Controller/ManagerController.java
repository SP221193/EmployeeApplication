package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Employee;
import com.app.Model.Manager;
import com.app.repository.ManagerRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping("/api")
public class ManagerController {

	@Autowired
	private ManagerRepository repository;
	
	@PostMapping(path = "/save-manager", consumes = "application/json", produces = "application/json")
	public Manager saveManager(@RequestBody Manager manager) {
		return repository.save(manager);
	}
	
	@GetMapping("/managers-list")
	public List<Manager> allManagers() {
		return repository.getManagers();
	}
	
	@GetMapping("/manager/{emailId}/{pass}")
	public Manager getManagerByEmailPassword(@PathVariable("emailId") String emailid, @PathVariable("pass") String pass, Manager manager) {
		System.out.print("Inside ");
		manager.setEmail(emailid);
		manager.setPassword(pass);
		System.out.print(emailid);
		System.out.print(pass);
		return repository.Validate(manager.getEmail(),manager.getPassword());
	}
	

	@RequestMapping("/ping")
	public void message() {
		System.out.print("Its working");
	}
}

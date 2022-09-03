package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.lead;
import com.marketing.exception.ResourceNotFound;
import com.marketing.services.leadService;


@RestController
@RequestMapping("/api/leads")
public class leadRestController {

	@Autowired
	private leadService leadServ;
	
	@GetMapping
	public List<lead> getAllLeads(){
		
		List<lead> leads = leadServ.listLeads();
		
		return leads;
		
	}
	
	@PostMapping
	public ResponseEntity<lead> saveOneLead(@RequestBody lead lead) {
	 lead l = leadServ.savelead(lead);
	return new ResponseEntity<lead>(l,HttpStatus.ACCEPTED);	
		}
	
	
//	@PostMapping
//	public void saveOneLead(@RequestBody lead lead) {
//		leadServ.savelead(lead);
//	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		if(id==1) {
			try {
			throw new ResourceNotFound();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		leadServ.deleteLeadById(id);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody lead lead) {
		leadServ.savelead(lead);
	}
	
	@GetMapping("/lead/{id}")
	public lead getOneLead(@PathVariable("id") long id) {
		lead l = leadServ.getOneLead(id);
		return l;
		
	}
	
	
}

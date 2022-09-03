package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.Repository.leadRepository;
import com.marketing.entities.lead;

@Service
public class leadServiceImpl implements leadService {

	@Autowired 
	private leadRepository leadRepo;
	
	
	@Override
	public lead savelead(lead lead) {

		lead l1 = leadRepo.save(lead);
		return l1;
	}

	@Override
	public List<lead> listLeads() {
		List<lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {

		leadRepo.deleteById(id);
	}

	@Override
	public lead getOneLead(long id) {
		Optional<lead> findById= leadRepo.findById(id);
		lead lead = findById.get();
		return lead;
		
	}

}

package com.marketing.services;

import java.util.List;

import com.marketing.entities.lead;



public interface leadService {

	public lead savelead(lead lead);

	public List<lead> listLeads();

	public void deleteLeadById(long id);

	public lead getOneLead(long id);
}

package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.leadData;
import com.marketing.entities.lead;
import com.marketing.services.leadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {

	
	@Autowired 
	private EmailService emailServ;
	
	@Autowired
	private leadService leadServ;
	
	
	// Handler Method	
	@RequestMapping("/createlead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") lead lead, ModelMap model) {
		emailServ.sendMail(lead.getEmail(),"Test","Test Email");
		leadServ.savelead(lead);
		model.addAttribute("msg","Lead is saved !!");
		return "create_lead";
		
	}
	
	@RequestMapping("/listAll")
	public String listAllLeads(ModelMap model) {
		List<lead> leads =  leadServ.listLeads();
//		System.out.println(leads);
		
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
//	DTO - Data Transfer Object
//	@RequestMapping("/saveLead")
//	public String saveOneLead(leadData data, ModelMap model) {
//		
//		lead l1 =new lead();
//		l1.setFirstName(data.getFirstName());
//		l1.setLastName(data.getLastName());
//		l1.setEmail(data.getEmail());
//		l1.setMobile(data.getMobile());
//		
//		leadServ.savelead(l1);
//		
//		model.addAttribute("msg","Lead is saved !!");
//		return "create_lead";
//		
//	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, ModelMap model )
	{
		
		leadServ.deleteLeadById(id);
		List<lead> leads =  leadServ.listLeads();
		
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id,ModelMap model) {
		lead lead = leadServ.getOneLead(id);
		
		model.addAttribute("lead", lead);
		
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLeadData(leadData data,ModelMap model) {
		
	 lead l =  new lead();
	 l.setId(data.getId());
	 l.setFirstName(data.getFirstName());
	 l.setLastName(data.getLastName());
	 l.setEmail(data.getEmail());
	 l.setMobile(data.getMobile());
	 
	 leadServ.savelead(l);
	 
	 List<lead> leads =  leadServ.listLeads();
		
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
}

package com.bhavik.apps.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bhavik.apps.contacts.dao.ContactDAO;
import com.bhavik.apps.contacts.model.Contact;

@Controller
@RequestMapping(value = "contacts")
public class HomeController {

	@Autowired
	private ContactDAO contactDAO;

	@GetMapping("home")
	public String displayHomePage(ModelMap model) {
		List<Contact> contacts = contactDAO.getAllContacts();
		System.out.println(contacts);
		model.put("contactList", contacts);
		return "home";
	}

}

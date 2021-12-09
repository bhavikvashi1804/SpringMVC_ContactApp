package com.bhavik.apps.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhavik.apps.contacts.dao.ContactDAO;
import com.bhavik.apps.contacts.model.Contact;
import com.bhavik.apps.contacts.service.ContactService;

@Controller
@RequestMapping(value = "contacts")
public class HomeController {

	@Autowired
	private ContactService contactService;

	@GetMapping("home")
	public String displayHomePage(ModelMap model) {
		List<Contact> contacts = contactService.getAllContacts();
		// System.out.println(contacts);
		model.put("contactList", contacts);
		return "home";
	}

	@GetMapping("dummy")
	@ResponseBody
	public String addSomeDummyRecords() {
		Contact c1 = new Contact("Bhavik", "Vashi", 7359791234l, "bhavikvashi@gmail.com");
		contactService.saveContact(c1);
		Contact c2 = new Contact("Raj", "Patel", 1232412312l, "rajpatel@gmail.com");
		contactService.saveContact(c2);
		return "Dummy records addedd Successfully";
	}

	@GetMapping("showAddContactForm")
	public String showAddContactForm(ModelMap modelMap) {
		Contact contact = new Contact();
		modelMap.put("contact", contact);
		return "contact-form";
	}

	@PostMapping("submitNewContactForm")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		// save the contact
		System.out.println(contact);
		// redirect to the contact
		return "redirect:home";
	}

}

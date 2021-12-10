package com.bhavik.apps.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhavik.apps.contacts.model.Contact;
import com.bhavik.apps.contacts.service.ContactService;

@Controller
@RequestMapping(value = "contacts")
public class HomeController {

	@Autowired
	private ContactService contactService;

	@GetMapping("home")
	public String displayHomePage(ModelMap model,
			@RequestParam(name = "sort", required = false, defaultValue = "0") int sortId,
			@RequestParam(required = false) String searchKeyword) {
		List<Contact> contacts = contactService.getAllContacts(sortId);
		// System.out.println(contacts);

		if (searchKeyword == "" || searchKeyword == null) {
			model.remove("searchKeyWord");
			System.out.println("Remove the search keyword");
		} else {
			model.put("searchKeyWord", searchKeyword);
			System.out.println("Yes, propogate the search key word");
		}

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
		modelMap.put("newContact", true);
		return "contact-form";
	}

	@GetMapping("showUpdateContactForm")
	public String showUpdateContactForm(@RequestParam("contactId") Long id, ModelMap modelMap) {
		Contact contact = contactService.getOneContact(id);
		modelMap.put("contact", contact);
		modelMap.put("newContact", false);
		return "contact-form";
	}

	@PostMapping("save-contact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		// save the contact
		// System.out.println(contact);
		contactService.saveContact(contact);
		// redirect to the contact
		return "redirect:/contacts/home";
	}

	@GetMapping("delete-contact")
	public String deleteContact(@RequestParam("contactId") Long id) {
		contactService.deleteContact(id);
		return "redirect:/contacts/home";
	}

	@GetMapping("search")
	public String searchTheContacts(@RequestParam("theSearchName") String firstName, ModelMap modelMap) {
		// System.out.println(firstName);
		List<Contact> contacts = contactService.searchContactByFirstName(firstName.trim());
		modelMap.put("contactList", contacts);
		modelMap.put("searchKeyWord", firstName);
		return "/home";
	}

}

package com.bhavik.apps.contacts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bhavik.apps.contacts.model.Contact;
import com.bhavik.apps.contacts.repository.ContactRepository;

@Component
public class ContactDAO {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts;
	}

	public Contact getOneContact(int id) {
		Contact contact = contactRepository.getById(id);
		return contact;
	}

	public void updateContact(Contact contact) {
		contactRepository.save(contact);
	}

	public void deleteContact(int id) {
		contactRepository.deleteById(id);
	}
}

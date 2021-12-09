package com.bhavik.apps.contacts.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bhavik.apps.contacts.dao.ContactDAO;
import com.bhavik.apps.contacts.model.Contact;
import com.bhavik.apps.contacts.repository.ContactRepository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepository.findAllByOrderByPhoneNoAsc();
		return contacts;
	}

	public Contact getOneContact(Long id) {
		Optional<Contact> contact = contactRepository.findById(id);
		return contact.get();
	}

	public void updateContact(Contact contact) {
		contactRepository.save(contact);
	}

	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}

}

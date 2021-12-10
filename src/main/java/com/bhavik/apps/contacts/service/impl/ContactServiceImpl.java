package com.bhavik.apps.contacts.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavik.apps.contacts.dao.ContactDAO;
import com.bhavik.apps.contacts.model.Contact;
import com.bhavik.apps.contacts.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Override
	@Transactional
	public List<Contact> getAllContacts(int sortId) {
		List<Contact> contacts = contactDAO.getAllContacts(sortId);
		return contacts;
	}

	@Override
	public Contact getOneContact(Long id) {
		Contact contact = contactDAO.getOneContact(id);
		return contact;
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
	}

	@Override
	public void saveContact(Contact contact) {
		contactDAO.saveContact(contact);
	}

	@Override
	public void deleteContact(Long id) {
		contactDAO.deleteContact(id);
	}

	@Override
	public List<Contact> searchContactByFirstName(String firstName) {
		List<Contact> contacts = contactDAO.searchContactByFirstName(firstName);
		return contacts;
	}
}

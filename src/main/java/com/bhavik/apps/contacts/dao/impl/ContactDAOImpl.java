package com.bhavik.apps.contacts.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bhavik.apps.contacts.dao.ContactDAO;
import com.bhavik.apps.contacts.model.Contact;
import com.bhavik.apps.contacts.repository.ContactRepository;
import com.bhavik.apps.contacts.util.SortUtils;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAllContacts(int sortId, String firstName) {
		List<Contact> contacts = new ArrayList<Contact>();

		if (firstName == null) {
			switch (sortId) {
			case SortUtils.FIRST_NAME:
				contacts = contactRepository.findAllByOrderByFirstNameAsc();
				break;
			case SortUtils.LAST_NAME:
				contacts = contactRepository.findAllByOrderByLastNameAsc();
				break;
			case SortUtils.EMAIL_ID:
				contacts = contactRepository.findAllByOrderByEmailIdAsc();
				break;
			default:
				contacts = contactRepository.findAll();
			}
		} else {
			switch (sortId) {
			case SortUtils.FIRST_NAME:
				contacts = contactRepository.findByFirstNameContainsOrderByFirstNameAsc(firstName);
				break;
			case SortUtils.LAST_NAME:
				contacts = contactRepository.findByFirstNameContainsOrderByLastNameAsc(firstName);
				break;
			case SortUtils.EMAIL_ID:
				contacts = contactRepository.findByFirstNameContainsOrderByEmailIdAsc(firstName);
				break;
			default:
				contacts = contactRepository.findByFirstNameContains(firstName);
			}

		}

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

	public List<Contact> searchContactByFirstName(String firstName) {
		List<Contact> filteredContactList = contactRepository.findByFirstNameContains(firstName);
		return filteredContactList;
	}

}

package com.bhavik.apps.contacts.service;

import java.util.List;

import com.bhavik.apps.contacts.model.Contact;

public interface ContactService {

	public List<Contact> getAllContacts(int id,String firstName);

	public Contact getOneContact(Long id);

	public void updateContact(Contact contact);

	public void saveContact(Contact contact);

	public void deleteContact(Long id);

	public List<Contact> searchContactByFirstName(String firstName);

}

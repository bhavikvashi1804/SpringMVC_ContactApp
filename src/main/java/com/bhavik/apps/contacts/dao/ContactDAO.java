package com.bhavik.apps.contacts.dao;

import java.util.List;

import com.bhavik.apps.contacts.model.Contact;

public interface ContactDAO {

	public List<Contact> getAllContacts();

	public Contact getOneContact(Long id);

	public void updateContact(Contact contact);

	public void saveContact(Contact contact);

	public void deleteContact(Long id);

}

package com.bhavik.apps.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavik.apps.contacts.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	public List<Contact> findAllByOrderByPhoneNoAsc();

	public List<Contact> findAllByOrderByFirstNameAsc();

	public List<Contact> findAllByOrderByLastNameAsc();

	public List<Contact> findAllByOrderByEmailIdAsc();

	public List<Contact> findByFirstNameContainsOrderByFirstNameAsc(String firstname);

	public List<Contact> findByFirstNameContainsOrderByLastNameAsc(String firstname);

	public List<Contact> findByFirstNameContainsOrderByEmailIdAsc(String firstname);

	public List<Contact> findByFirstNameContains(String firstname);

}

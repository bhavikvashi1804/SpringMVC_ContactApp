package com.bhavik.apps.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavik.apps.contacts.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	public List<Contact> findAllByOrderByPhoneNoAsc();

	public List<Contact> findByFirstNameContains(String firstname);

}

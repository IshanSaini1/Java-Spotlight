package com.kata.series.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kata.series.model.Contact;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
public interface ContactRepositoryJPA extends JpaRepository<Contact, Integer> {

	public Contact findByContactId(Integer contactId);

	public List<Contact> findByStatus(String constant);

	public Page<Contact> findByStatus(String constant, Pageable pageable);

	@Query(value = "select c from Contact c where c.status = :status")
	public Page<Contact> findByStatusJPQL(String status, Pageable pageable);

	@Query(value = "select * from contact_msg c where c.status = :status", nativeQuery = true)
	public Page<Contact> findByStatusNative(String status, Pageable pageable);

	@Transactional(value = TxType.REQUIRED)
	@Modifying
	@Query(value = "update Contact c set c.status = :status where c.contactId = :id")
	public int updateStatusById(Integer id, String status);

	
	public Page<Contact> findOpenMsg(@Param("status") String status, Pageable pageable);

	@Transactional
	@Modifying
	int updateMsgStatus(String status, int id);

}

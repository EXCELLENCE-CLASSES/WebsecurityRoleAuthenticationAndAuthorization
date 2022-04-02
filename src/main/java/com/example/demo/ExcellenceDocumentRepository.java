package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExcellenceDocumentRepository extends JpaRepository<ExcellenceDocument, Long> {
	
	@Query("SELECT new ExcellenceDocument(d.id, d.name, d.size) FROM ExcellenceDocument d ORDER BY d.uploadTime DESC")
	List<ExcellenceDocument> findAll();

}

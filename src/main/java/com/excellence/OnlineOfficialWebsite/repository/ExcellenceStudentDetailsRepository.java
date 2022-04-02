package com.excellence.OnlineOfficialWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellence.OnlineOfficialWebsite.model.ExcellenceStudentDetails;

@Repository
public interface ExcellenceStudentDetailsRepository extends JpaRepository<ExcellenceStudentDetails,String> {
	

}

package com.excellence.OnlineOfficialWebsite.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.excellence.OnlineOfficialWebsite.model.ExcellenceClassesDetails;
import com.excellence.OnlineOfficialWebsite.model.ExcellenceStudentDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Service
public class ExcellenceService {
	
	@Autowired
	public ExcellenceStudentDetails excs;
	@Autowired
	private ExcellenceClassesDetails excellenceDetails;

	public ExcellenceClassesDetails getExcellenceDetails() {
		return excellenceDetails;
	}

	public void setExcellenceDetails(ExcellenceClassesDetails excellenceDetails) {
		this.excellenceDetails = excellenceDetails;
	}

	@Override
	public String toString() {
		return "ExcellenceService [excellenceDetails=" + excellenceDetails + "]";
	}
	
	

	
	
	
	
	
	

}

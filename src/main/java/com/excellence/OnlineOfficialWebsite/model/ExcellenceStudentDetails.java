package com.excellence.OnlineOfficialWebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="excellenceStudent")
@Component
public class ExcellenceStudentDetails {
	
	            
	            @Id 
	            @Column(name="studentId")
	            private int studentId;
	            @Column(name="studentName")
	            private String studentName;
	            
	            @Column(name="studentCurrentAddress")
	            private String studentCurrentAddress;
	            @Column(name="studentPermanentAddress")
	            private String studentPermanentAddress;
	            @Column(name=" studentAge")
	            private String studentAge ;
	            @Column(name="studentDateOfBirth")
	            private String studentDateOfBirth;

				

				public int getStudentId() {
					return studentId;
				}

				public void setStudentId(int studentId) {
					this.studentId = studentId;
				}

				public String getStudentName() {
					return studentName;
				}

				public void setStudentName(String studentName) {
					this.studentName = studentName;
				}

				public String getStudentCurrentAddress() {
					return studentCurrentAddress;
				}

				public void setStudentCurrentAddress(String studentCurrentAddress) {
					this.studentCurrentAddress = studentCurrentAddress;
				}

				public String getStudentPermanentAddress() {
					return studentPermanentAddress;
				}

				public void setStudentPermanentAddress(String studentPermanentAddress) {
					this.studentPermanentAddress = studentPermanentAddress;
				}

				public String getStudentAge() {
					return studentAge;
				}

				public void setStudentAge(String studentAge) {
					this.studentAge = studentAge;
				}

				public String getStudentDateOfBirth() {
					return studentDateOfBirth;
				}

				public void setStudentDateOfBirth(String studentDateOfBirth) {
					this.studentDateOfBirth = studentDateOfBirth;
				}

				@Override
				public String toString() {
					return "ExcellenceStudentDetails [studentId=" + studentId + ", studentName=" + studentName
							+ ", studentCurrentAddress=" + studentCurrentAddress + ", studentPermanentAddress="
							+ studentPermanentAddress + ", studentAge=" + studentAge + ", studentDateOfBirth="
							+ studentDateOfBirth + "]";
				}
	            
	            
	            
	            
	            
	             
	            
	             
	             
	
	

}

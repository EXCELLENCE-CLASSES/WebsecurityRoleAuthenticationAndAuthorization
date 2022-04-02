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
@Table(name="excellenceTeacher")
@Component
public class ExcellenceTeacherDetails {
	
	
	   @Id 
	   @Column(name="teacherId")
	   private int teacherId;
	   @Column(name="teacherName")
	   private String teacherName;
	   @Column(name="teacherCurrentAddress")
	   private String teacherCurrentAddress;
	   @Column(name="teacherPermanentAddress")
	   private String teacherPermanentAddress;
	   @Column(name="teacherAge")
	   private String teacherAge ;

	
	

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherCurrentAddress() {
		return teacherCurrentAddress;
	}

	public void setTeacherCurrentAddress(String teacherCurrentAddress) {
		this.teacherCurrentAddress = teacherCurrentAddress;
	}

	public String getTeacherPermanentAddress() {
		return teacherPermanentAddress;
	}

	public void setTeacherPermanentAddress(String teacherPermanentAddress) {
		this.teacherPermanentAddress = teacherPermanentAddress;
	}

	public String getTeacherAge() {
		return teacherAge;
	}

	public void setTeacherAge(String teacherAge) {
		this.teacherAge = teacherAge;
	}

	@Override
	public String toString() {
		return "ExcellenceTeacherDetails [teacherId=" + teacherId + ", teacherName=" + teacherName
				+ ", teacherCurrentAddress=" + teacherCurrentAddress + ", teacherPermanentAddress="
				+ teacherPermanentAddress + ", teacherAge=" + teacherAge + "]";
	}
       
       
	
	
	

}

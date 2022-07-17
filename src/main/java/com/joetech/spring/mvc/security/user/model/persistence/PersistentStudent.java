package com.joetech.spring.mvc.security.user.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Persistent implementation of {@code Student}.
 * 
 * @author Joe
 *
 */
@Entity(name = "StudentDetails")
@Table(name = "STUDENTS")
public class PersistentStudent {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id", nullable = false)
	 private int id;
	 @Column(name = "name", nullable = false, length = 20)
	 private String name;
	 @Column(name = "mobile", nullable = false)
	 private Long mobile;
	 @Column(name = "country", nullable = false, length = 20)
	 private String country;
	 @Column(name = "idno", nullable = false, length = 20)
	 private String idno;
	 /**
	     * Default constructor.
	     */
	public PersistentStudent() {
		super();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + ", idno=" + idno
				+ "]";
	}
	 
	 
	

}

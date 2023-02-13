package com.greedy.member.model.dto;

import java.sql.Date;

public class MemberDTO {

	private int number;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private int age;
	private java.sql.Date enrolldate;

	public MemberDTO() {}

	public MemberDTO(int number, String id, String pwd, String name, String gender, String email, String phone,
			String address, int age, java.sql.Date enrolldate) {
		this.number = number;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.enrolldate = enrolldate;
	}

	public int getNumber() {
		return number;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	public java.sql.Date getEnrolldate() {
		return enrolldate;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEnrolldate(java.sql.Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		return "MemberDTO [number=" + number + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", age=" + age + ", enrolldate="
				+ enrolldate + "]";
	}

}



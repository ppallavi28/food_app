package com.clarivate.food_app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BranchManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bm_id;
	private String bm_name;
	private String email;
	private String password;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Staff> staff;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Menu> menu;
	
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	@JsonIgnore
	private Branch branch;
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public int getBm_id() {
		return bm_id;
	}
	public void setBm_id(int bm_id) {
		this.bm_id = bm_id;
	}
	public String getBm_name() {
		return bm_name;
	}
	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}

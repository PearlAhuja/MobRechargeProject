package com.dumbledore.mobrecharge.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dumbledore.mobrecharge.model.myenum.Gender;
import com.sun.istack.NotNull;



@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private Long mobileNumber;

	@NotNull
	private String dateOfBirth;

	@NotNull
	private Gender gender;

	@NotNull
	private String dateOfCreation;

	private String dateOfUpdate;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	

	/*
	 * Mapping ( User -> Bank Account )
	 */
	@OneToMany(cascade = CascadeType.ALL)
	private List<BankAccount> bankAccountsList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<CardDetail>cardlist=new HashSet<>();


	/*
	 * @Constructors
	 */
	public User() {}
	
	public User(String username, String email, String password, String firstName, String lastName, Long mobileNumber,
			String dateOfBirth, Gender gender) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.dateOfCreation = new Date().toString();
		this.dateOfUpdate = new Date().toString();
	}

	/*
	 * @Getters
	 * 
	 * @Setters
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation() {
		this.dateOfCreation = (new Date()).toString();
	}

	public String getDateOfUpdate() {
		return dateOfUpdate;
	}

	public void setDateOfUpdate() {
		this.dateOfUpdate = new Date().toString();
	}

	public List<BankAccount> getBankAccountsList() {
		return bankAccountsList;
	}

	public void setBankAccountsList(List<BankAccount> bankAccountsList) {
		this.bankAccountsList = bankAccountsList;
	}
	public Set<CardDetail> getCardlist() {
		return cardlist;
	}

	public void setCardlist(Set<CardDetail> cardlist) {
		this.cardlist = cardlist;
	}
	public Integer getId() {
		return userId;
	}

	public void setId(Integer id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

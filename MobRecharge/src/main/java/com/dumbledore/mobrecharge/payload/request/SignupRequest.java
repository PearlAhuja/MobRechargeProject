package com.dumbledore.mobrecharge.payload.request;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;

import com.dumbledore.mobrecharge.model.myenum.Gender;
import com.sun.istack.NotNull;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    
    private Set<String> role = new HashSet<>();
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    
    @NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private Long mobileNumber;

	@NotBlank
	private String dateOfBirth;

	@NotBlank
	private Gender gender;

	@NotBlank
	private String dateOfCreation;

	private String dateOfUpdate;
	
	
    
    
    /*
     * @Getters
     *    &
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
		this.dateOfUpdate = (new Date()).toString();
	}

	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
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
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}

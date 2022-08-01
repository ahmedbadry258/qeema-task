package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "First Name Must Be Not Blank")
	@NotEmpty(message = "First Name Must Be Not Empty")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last Name Must Be Not Blank")
	@NotEmpty(message = "Last Name Must Be Not Empty")
	@Column(name = "last_name")
	private String lastName;
	
	@Email(message = "should be email Valid")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Password  Must Be Not Blank")
	@NotEmpty(message = "Password  Must Be Not Empty")
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}

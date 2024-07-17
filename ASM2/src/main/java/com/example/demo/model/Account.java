package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "Account")
public class Account implements Serializable {
	@Id
	@NotBlank(message = "Không để trống")
	String username;
	@NotBlank(message = "Không để trống")
	String password;
	@NotBlank(message = "Không để trống")
	String fullname;
	@NotBlank(message = "Không để trống")
	String email;
	@NotNull
	String photo;
	@NotNull
	boolean activated;
	@NotNull
	boolean admin;
	@OneToMany(mappedBy = "account")
	List<Order> orders;

}

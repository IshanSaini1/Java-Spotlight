package com.kata.series.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int contactId;

	@NotBlank(message = "Name field cannot be blank.")
	@Size(min = 3, message = "Name must be greater than 3")
	private String name;

	@NotBlank
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be equal to 10 digits.")
	private String mobileNum;

	@NotBlank(message = "Email must not be blank")
	@Email(message = "not a proper email format.")
	private String email;

	@NotBlank(message = "Subject cannot be blank")
	private String subject;

	@NotBlank(message = "message cannot be blank")
	private String message;
	
	private String status;

}

package com.rboudhar001.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	// Fields

	@Id
	@Column(name = "user_id")
	private long id;

	@Size(max = 45)
	@Column(name = "user_name", length = 45)
	private String name;

	@NotNull
	@NotEmpty
	@Size(max = 45)
	@Column(name = "user_city", length = 45, nullable = false)
	private String city;

	// Set and Get

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// Functions

	// ...
}
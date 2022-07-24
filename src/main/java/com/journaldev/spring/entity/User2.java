package com.journaldev.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user4")
public class User2 {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@JsonProperty
    private int id;
	
	@JsonProperty
    @Column
    private String firstName;
	
	@JsonProperty
    @Column
    private String lastName;
	
	@JsonProperty
    @Column
    private String email;

    public User2(int id, String firstName, String lastName, String email) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

	@Override
	public String toString() {
		return "User2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
    
}
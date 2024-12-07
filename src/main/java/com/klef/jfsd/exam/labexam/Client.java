package com.klef.jfsd.exam.labexam;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marks the class as a JPA entity
@Table(name = "customer") // Specifies the table name in the database for this entity class
public class Client {
    
    @Id // Marks the 'id' field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID value using the identity strategy (auto-increment)
    private int id;

    private String name; // The 'name' field of the client
    private String gender; // The 'gender' field of the client
    private int age; // The 'age' field of the client
    private String location; // The 'location' field of the client
    private String email; // The 'email' field of the client
    private String mobileNumber; // The 'mobileNumber' field of the client

    // Getters and Setters for each field
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Override the toString method to display the details of the client in a readable format
    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", location=" + location
                + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
    }
}

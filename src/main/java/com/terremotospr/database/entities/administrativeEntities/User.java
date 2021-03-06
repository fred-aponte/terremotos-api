package com.terremotospr.database.entities.administrativeEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on March 15, 2020 - 9:24 PM
 *
 * @author Victor Nazario
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String line1;
    private String line2;
    private String city;
    private String country;
    private String region;
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonIgnore
    @OneToMany(targetEntity=Manages.class, mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private Set<Manages> manages = new HashSet<>();

    public Set<Manages> getManages() { return manages; }

    public void setManages(Set<Manages> manages) { this.manages = manages; }
}
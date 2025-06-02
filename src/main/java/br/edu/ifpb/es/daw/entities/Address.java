package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    private String country;
    private String city;
    private String street;
    private String zip;

    @OneToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", unique = true)
    private Organization organization;

    public Address() {
    }

    public Address(UUID id, String country, String city, String street, String zip, Organization organization) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.organization = organization;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city=" + city +
                ", street=" + street +
                ", zip=" + zip +
                ", organization=" + organization +
                '}';
    }
}
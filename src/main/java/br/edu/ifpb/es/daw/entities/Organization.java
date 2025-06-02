package br.edu.ifpb.es.daw.entities;

import br.edu.ifpb.es.daw.entities.enums.OrganizationStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(length = 255)
    private String name;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrganizationStatus status;

    @Column(name = "business_size")
    private String businessSize;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserOrganization> users;

    public Organization() {
    }

    public Organization(UUID id, String name, LocalDateTime registrationDate,
                        OrganizationStatus status, String businessSize, List<Project> projects, List<UserOrganization> users) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.status = status;
        this.businessSize = businessSize;
        this.projects = projects;
        this.users = users;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public OrganizationStatus getStatus() {
        return status;
    }

    public void setStatus(OrganizationStatus status) {
        this.status = status;
    }

    public String getBusinessSize() {
        return businessSize;
    }

    public void setBusinessSize(String businessSize) {
        this.businessSize = businessSize;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<UserOrganization> getUsers() {
        return users;
    }

    public void setUsers(List<UserOrganization> users) {
        this.users = users;
    }

    public void addUserOrganization(UserOrganization userOrg) {
        if (users == null) {
            users = new ArrayList<>();
        }
        userOrg.setOrganization(this);
        this.users.add(userOrg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization organization = (Organization) o;
        return id.equals(organization.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", status=" + status +
                ", businessSize=" + businessSize +
                ", projects=" + (projects != null ? projects.size() : 0) +
                ", users=" + (users != null ? users.size() : 0) +
                '}';
    }
}
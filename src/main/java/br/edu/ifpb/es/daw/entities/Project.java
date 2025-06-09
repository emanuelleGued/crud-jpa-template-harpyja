package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    private String name;
    private String key;
    private String type;

    @Column(name = "expiration")
    private LocalDateTime expiration;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<UserProject> users;

    public Project() {
    }

    public Project(UUID id, String name, String key, String type, LocalDateTime expiration, Organization organization, List<UserProject> users) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.type = type;
        this.expiration = expiration;
        this.organization = organization;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

   public Organization getOrganization() {
        return organization;
    }

    public List<UserProject> getUsers() {
        return users;
    }

    public void setUsers(List<UserProject> users) {
        this.users = users;
    }

    public void addUserProject(UserProject userProject) {
        if (users == null) {
            users = new ArrayList<>();
        }
        userProject.setProject(this);
        this.users.add(userProject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", expiration=" + expiration +
                ", organizationId=" + (organization != null ? organization.getId() : null) +
                 ", usersSize=" + (users != null ? users.size() : 0) +
                '}';
    }
}
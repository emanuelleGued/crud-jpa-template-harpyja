package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "organization_id")
    private UUID organizationId;

    public Project() {
    }

    public Project(UUID id, String name, String key, String type,
                   LocalDateTime expiration, UUID organizationId) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.type = type;
        this.expiration = expiration;
        this.organizationId = organizationId;
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

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
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
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key=" + key +
                ", expiration=" + expiration +
                ", organizationId=" + organizationId +
                '}';
    }
}
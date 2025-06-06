package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    private String name;

    private String description;

    private String type;

    @Column(name = "default_project_role_id")
    private String defaultProjectRoleId;

    public Role() {
    }

    public Role(UUID id, String name, String description, String type, String defaultProjectRoleId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.defaultProjectRoleId = defaultProjectRoleId;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultProjectRoleId() {
        return defaultProjectRoleId;
    }
    public void setDefaultProjectRoleId(String defaultProjectRoleId) {
        this.defaultProjectRoleId = defaultProjectRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", type=" + type +
                ", defaultProjectRoleId=" + defaultProjectRoleId +
                '}';
    }
}

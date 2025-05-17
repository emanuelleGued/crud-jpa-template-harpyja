package br.edu.ifpb.es.daw.entities;

import br.edu.ifpb.es.daw.entities.enums.OrganizationRole;
import br.edu.ifpb.es.daw.entities.enums.ProjectRole;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_organization")
public class UserOrganization {
    @EmbeddedId
    private UserOrganizationId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private OrganizationRole role;

    @Transient
    private ProjectRole defaultProjectRole;

    public UserOrganization() {
    }

    public UserOrganization(UserOrganizationId id, OrganizationRole role, ProjectRole defaultProjectRole) {
        this.id = id;
        this.role = role;
        this.defaultProjectRole = defaultProjectRole;
    }

    public UserOrganizationId getId() {
        return id;
    }
    public void setId(UserOrganizationId id) {
        this.id = id;
    }

    public OrganizationRole getRole() {
        return role;
    }
    public void setRole(OrganizationRole role) {
        this.role = role;
    }

    public ProjectRole getDefaultProjectRole() {
        return defaultProjectRole;
    }
    public void setDefaultProjectRole(ProjectRole defaultProjectRole) {
        this.defaultProjectRole = defaultProjectRole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrganization userOrganization = (UserOrganization) o;
        return id.equals(userOrganization.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", defaultProjectRole=" + defaultProjectRole +
                '}';
    }
}

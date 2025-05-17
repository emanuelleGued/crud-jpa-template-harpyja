package br.edu.ifpb.es.daw.entities;

import br.edu.ifpb.es.daw.entities.enums.ProjectRole;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_project")
public class UserProject {

    @EmbeddedId
    private UserProjectId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ProjectRole role;


    public UserProject() {
    }

    public UserProject(UserProjectId id, ProjectRole role) {
        this.id = id;
        this.role = role;
    }

    public UserProjectId getId() {
        return id;
    }
    public void setId(UserProjectId id) {
        this.id = id;
    }

    public ProjectRole getRole() {
        return role;
    }
    public void setRole(ProjectRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProject userProject = (UserProject) o;
        return id.equals(userProject.id);
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
                '}';
    }

}

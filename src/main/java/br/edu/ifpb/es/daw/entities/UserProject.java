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

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("projectId")
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


    public UserProject() {
    }

    public UserProject(UserProjectId id, ProjectRole role, User user, Project project) {
        this.id = id;
        this.role = role;
        this.user = user;
        this.project = project;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
        return "UserProject{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user='" + user +
                ", project='" + project +
                '}';
    }

}

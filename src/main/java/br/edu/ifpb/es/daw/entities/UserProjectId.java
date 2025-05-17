package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserProjectId {
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "project_id")
    private UUID projectId;

    public UserProjectId() {
    }

    public UserProjectId(UUID userId, UUID projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getProjectId() {
        return projectId;
    }
    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProjectId)) return false;
        UserProjectId that = (UserProjectId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, projectId);
    }
}

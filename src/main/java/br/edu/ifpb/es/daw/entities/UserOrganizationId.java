package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserOrganizationId {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "organization_id")
    private UUID organizationId;

    public UserOrganizationId() {
    }

    public UserOrganizationId(UUID userId, UUID organizationId) {
        this.userId = userId;
        this.organizationId = organizationId;
    }

    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
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
        if (!(o instanceof UserOrganizationId)) return false;
        UserOrganizationId that = (UserOrganizationId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }
}

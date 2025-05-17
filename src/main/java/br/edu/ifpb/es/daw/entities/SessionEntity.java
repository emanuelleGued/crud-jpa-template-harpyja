package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "sessions")
public class SessionEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "device_time")
    private LocalDateTime deviceTime;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    @Column(name = "recording_time")
    private LocalDateTime recordingTime;

    @Column(name = "project_id")
    private UUID projectId;

    public SessionEntity() {
    }

    public SessionEntity(UUID id, LocalDateTime deviceTime, LocalDateTime uploadTime,
                         LocalDateTime recordingTime, UUID projectId) {
        this.id = id;
        this.deviceTime = deviceTime;
        this.uploadTime = uploadTime;
        this.recordingTime = recordingTime;
        this.projectId = projectId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(LocalDateTime deviceTime) {
        this.deviceTime = deviceTime;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public LocalDateTime getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(LocalDateTime recordingTime) {
        this.recordingTime = recordingTime;
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
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity sessionEntity = (SessionEntity) o;
        return id.equals(sessionEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", deviceTime='" + deviceTime + '\'' +
                ", uploadTime=" + uploadTime +
                ", recordingTime=" + recordingTime +
                ", projectId=" + projectId +
                '}';
    }
}
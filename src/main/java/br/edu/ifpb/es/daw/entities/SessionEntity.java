package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Activity> activities;

    public SessionEntity() {
    }

    public SessionEntity(UUID id, LocalDateTime deviceTime, LocalDateTime uploadTime,
                         LocalDateTime recordingTime, Project project) {
        this.id = id;
        this.deviceTime = deviceTime;
        this.uploadTime = uploadTime;
        this.recordingTime = recordingTime;
        this.project = project;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new ArrayList<>();
        }
        activity.setSession(this);
        this.activities.add(activity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity sessionEntity = (SessionEntity) o;
        return id.equals(sessionEntity  .id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", deviceTime='" + deviceTime + '\'' +
                ", uploadTime=" + uploadTime +
                ", recordingTime=" + recordingTime +
                ", project=" + project +
                '}';
    }
}
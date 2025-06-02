package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "gestures")
public class Gestures {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "target_time")
    private String targetTime;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "coordinates")
    private String coordinates;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

    public Gestures() {
    }

    public Gestures(UUID id, String targetTime, String createdAt, String coordinates, Activity activity) {
        this.id = id;
        this.targetTime = targetTime;
        this.createdAt = createdAt;
        this.coordinates = coordinates;
        this.activity = activity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(String targetTime) {
        this.targetTime = targetTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestures gestures = (Gestures) o;
        return id.equals(gestures.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", targetTime='" + targetTime + '\'' +
                ", createdAt=" + createdAt +
                ", coordinates=" + coordinates +
                ", activity=" + activity +
                '}';
    }
}
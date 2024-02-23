package com.example.coursedivision.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Course")
@Data
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long duration;
    private Boolean undergraduate;
    private Long ebCertificate;
    private String baRating;

    // Division field
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getUndergraduate() {
        return undergraduate;
    }

    public void setUndergraduate(Boolean undergraduate) {
        this.undergraduate = undergraduate;
    }

    public Long getEbCertificate() {
        return ebCertificate;
    }

    public void setEbCertificate(Long ebCertificate) {
        this.ebCertificate = ebCertificate;
    }

    public String getBaRating() {
        return baRating;
    }

    public void setBaRating(String baRating) {
        this.baRating = baRating;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}

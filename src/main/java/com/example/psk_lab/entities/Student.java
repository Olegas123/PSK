package com.example.psk_lab.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Basic(optional = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic(optional = false)
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne
    private com.example.psk_lab.entities.Groups groups;

    public com.example.psk_lab.entities.Groups getGroup() {
        return groups;
    }

    public void setGroup(com.example.psk_lab.entities.Groups groups) {
        this.groups = groups;
    }

    @ManyToMany
    private List<OptionalCourses> optionalCourses;

    public List<OptionalCourses> getOptionalCourses() {
        return optionalCourses;
    }

    public void setOptionalCourses(List<OptionalCourses> optionalCourses) {
        this.optionalCourses = optionalCourses;
    }
}

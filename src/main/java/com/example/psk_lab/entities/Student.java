package com.example.psk_lab.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String surname;

    @Basic
    private String login;

    @ManyToOne
    private com.example.psk_lab.entities.Groups groups;

    @ManyToMany
    private List<OptionalCourses> optionalCourses;

    @Version
    private int version;

    /// ################ Getters - Setters ################ ///
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public com.example.psk_lab.entities.Groups getGroup() {
        return groups;
    }

    public void setGroup(com.example.psk_lab.entities.Groups groups) {
        this.groups = groups;
    }

    public List<OptionalCourses> getOptionalCourses() {
        return optionalCourses;
    }

    public void setOptionalCourses(List<OptionalCourses> optionalCourses) {
        this.optionalCourses = optionalCourses;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
package com.example.psk_lab.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class OptionalCourses {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "optionalCourses")
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

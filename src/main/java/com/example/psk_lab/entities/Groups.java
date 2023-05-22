package com.example.psk_lab.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Groups.findAll", query = "select g from Groups as g")
})
public class Groups {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String direction;

    @Basic(optional = false)
    private Integer course;

    @OneToMany(mappedBy = "groups")
    private List<Student> students;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

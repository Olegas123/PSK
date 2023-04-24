package com.example.psk_lab.persistence;

import com.example.psk_lab.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class StudentDAO {
    @Inject
    private EntityManager em;

    @Transactional
    public void persist(Student student){
        this.em.persist(student);
    }

}

package com.example.psk_lab.persistence;

import com.example.psk_lab.entities.Groups;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GroupsDAO {
    @Inject
    private EntityManager em;

    public List<Groups> loadAll() {
        return em.createNamedQuery("Groups.findAll", Groups.class).getResultList();
    }

    public void persist(Groups group){
        this.em.persist(group);
    }

    public Groups findOne(Long id) {
        return em.find(Groups.class, id);
    }

    @Transactional
    public Groups merge(Groups group) {
        return em.merge(group);
    }
}

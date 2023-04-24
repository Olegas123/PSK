package com.example.psk_lab.use_cases;

import com.example.psk_lab.entities.Groups;
import com.example.psk_lab.persistence.GroupsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Group implements Serializable {
    @Inject
    private GroupsDAO groupsDAO;

    @Getter
    @Setter
    private Groups groupToCreate = new Groups();

    @Getter
    private List<Groups> allGroups;

    @PostConstruct
    public void init(){
        loadAllGroups();
    }

    @Transactional
    public void createGroup(){
        this.groupsDAO.persist(groupToCreate);
    }

    private void loadAllGroups(){
        this.allGroups = groupsDAO.loadAll();
    }
}

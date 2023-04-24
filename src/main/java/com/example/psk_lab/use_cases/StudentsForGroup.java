package com.example.psk_lab.use_cases;

import com.example.psk_lab.entities.Groups;
import com.example.psk_lab.entities.Student;
import com.example.psk_lab.interceptors.LoggedInvocation;
import com.example.psk_lab.persistence.GroupsDAO;
import com.example.psk_lab.persistence.StudentDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class StudentsForGroup implements Serializable {

    @Inject
    private GroupsDAO groupsDAO;

    @Inject
    private StudentDAO studentDAO;

    @Getter
    @Setter
    private Groups groups;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long groupsId = Long.parseLong(requestParameters.get("groupsId"));
        this.groups = groupsDAO.findOne(groupsId);
    }

    @Transactional
    @LoggedInvocation
    public void createStudent() {
        studentToCreate.setGroup(this.groups);
        studentDAO.persist(studentToCreate);
    }
}

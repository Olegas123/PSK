package com.example.psk_lab.use_cases;

import com.example.psk_lab.entities.Student;
import com.example.psk_lab.persistence.StudentDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateStudentDetails implements Serializable {

    private Student student;

    @Inject
    private StudentDAO studentDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateStudentDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String studentIdParam = requestParameters.get("studentId");
        if (studentIdParam != null) {
            Long studentId = Long.parseLong(studentIdParam);
            this.student = studentDAO.findOne(studentId);
        }
    }

    @Transactional
    public String updateStudent() {
        try{
            studentDAO.merge(this.student);
        } catch (OptimisticLockException e) {
            return "/studentDetails.xhtml?faces-redirect=true&studentId=" + this.student.getId() + "&error=optimistic-lock-exception";
        }
        return "students.xhtml?groupsId=" + this.student.getGroup().getId() + "&faces-redirect=true";
    }
}
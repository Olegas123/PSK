package com.example.psk_lab.use_cases;

import com.example.psk_lab.mybatis.dao.GroupsMapper;
import com.example.psk_lab.mybatis.model.Groups;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class GroupMyBatis {
    @Inject
    private GroupsMapper groupsMapper;

    @Getter
    private List<Groups> allGroups;

    @Getter @Setter
    private Groups groupsToCreate = new Groups();

    @PostConstruct
    public void init() {
        this.loadAllGroups();
    }

    private void loadAllGroups() {
        this.allGroups = groupsMapper.selectAll();
    }

    @Transactional
    public String createGroup() {
        groupsMapper.insert(groupsToCreate);
        return "/myBatis/groups?faces-redirect=true";
    }
}

package com.example.psk_lab.rest;

import com.example.psk_lab.entities.Groups;
import com.example.psk_lab.persistence.GroupsDAO;
import com.example.psk_lab.rest.contracts.GroupDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/groups")
public class GroupsController {

    @Inject
    @Setter
    @Getter
    private GroupsDAO groupsDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGroups() {
        List<Groups> groups = groupsDAO.loadAll();
        List<GroupDto> groupDtos = groups.stream()
                .map(group -> {
                    GroupDto groupDto = new GroupDto();
                    groupDto.setCourse(group.getCourse());
                    groupDto.setDirection(group.getDirection());
                    return groupDto;
                })
                .collect(Collectors.toList());

        return Response.ok(groupDtos).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Groups group = groupsDAO.findOne(id);
        if (group == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        GroupDto groupDto = new GroupDto();
        groupDto.setCourse(group.getCourse());
        groupDto.setDirection(group.getDirection());

        return Response.ok(groupDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(GroupDto groupData) {
        Groups newGroup = new Groups();
        newGroup.setCourse(groupData.getCourse());
        newGroup.setDirection(groupData.getDirection());
        groupsDAO.persist(newGroup);
        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Long groupId,
            GroupDto groupData) {
        try {
            Groups currentGroup = groupsDAO.findOne(groupId);
            if (currentGroup == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            currentGroup.setCourse(groupData.getCourse());
            currentGroup.setDirection(groupData.getDirection());
            groupsDAO.merge(currentGroup);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
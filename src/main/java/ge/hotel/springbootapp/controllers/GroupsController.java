package ge.hotel.springbootapp.controllers;

import ge.hotel.springbootapp.entities.Groups;
import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupsController {
    private final GroupService groupService;

    @PostMapping("/create")
    public Groups createGroup(@RequestBody Groups group) {
        return groupService.createGroup(group);
    }

    @PutMapping("/edit/{groupId}")
    public Groups editGroupInfo(@PathVariable Integer groupId, @RequestBody Groups editedGroup) {
        return groupService.editGroupInfo(groupId, editedGroup);
    }

    @DeleteMapping("/delete/{groupId}")
    public void deleteGroup(@PathVariable Integer groupId) {
        groupService.deleteGroup(groupId);
    }

    @GetMapping("/search")
    public List<Groups> getAllGroups(){
        return groupService.getAllGroups();
    }

}

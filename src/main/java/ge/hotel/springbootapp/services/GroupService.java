package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Groups;
import ge.hotel.springbootapp.entities.Student;

import java.util.List;

public interface GroupService {
    Groups createGroup(Groups group);
    Groups editGroupInfo(Integer groupId, Groups editedGroup);
    void deleteGroup(Integer groupId);
    List<Groups> getAllGroups();
}

package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Groups;
import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.repositories.GroupsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupsRepository groupsRepository;

    @Override
    public Groups createGroup(Groups group) {
        return groupsRepository.save(group);
    }

    @Override
    public Groups editGroupInfo(Integer groupId, Groups editedGroup) {
        Groups existingGroup = groupsRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Group not found with this ID"));
        existingGroup.setGroupNumber(editedGroup.getGroupNumber());
        existingGroup.setStudentIds(editedGroup.getStudentIds());
        existingGroup.setTeacherId(editedGroup.getTeacherId());
//        existingGroup.setStudent(editedGroup.getStudent());
//        existingGroup.setTeacher(editedGroup.getTeacher());
        return groupsRepository.save(existingGroup);
    }

    @Override
    public void deleteGroup(Integer groupId) {groupsRepository.deleteById(groupId);

    }

    @Override
    public List<Groups> getAllGroups() {
        return groupsRepository.findAll();
    }




}

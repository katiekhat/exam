package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.entities.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    Teacher editTeacherInfo(Integer teacherId, Teacher teacher);
    void deleteTeacher(Integer teacherId);
    List<Teacher> search(String firstName,String lastName,String personalNumber);
}

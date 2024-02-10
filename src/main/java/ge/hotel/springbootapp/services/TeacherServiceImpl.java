package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.entities.Teacher;
import ge.hotel.springbootapp.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public Teacher createTeacher(Teacher teacher) {
        if (teacher.getFirstName().isEmpty()|| teacher.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Fill both: First name and Last name fields.");
        }
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher editTeacherInfo(Integer teacherId, Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("teacher not found with this ID"));
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setPersonalNumber(teacher.getPersonalNumber());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhoneNumber(teacher.getPhoneNumber());
        return teacherRepository.save(existingTeacher);
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public List<Teacher> search(String firstName, String lastName, String personalNumber) {
        if (firstName != null) {
            return teacherRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return teacherRepository.findByLastName(lastName);
        } else if (personalNumber != null) {
            return teacherRepository.findByPersonalNumber(personalNumber);
        } else {
            return teacherRepository.findAll();
        }    }


}

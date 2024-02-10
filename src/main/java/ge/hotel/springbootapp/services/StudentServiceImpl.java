package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        if (student.getFirstName().isEmpty()|| student.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Fill both: First name and Last name fields.");
        }
        return studentRepository.save(student);
    }
    @Override
    public Student editStudentInfo(Integer studentId, Student student) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with this ID"));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setPersonalNumber(student.getPersonalNumber());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        return studentRepository.save(existingStudent);
    }
    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> search(String firstName,String lastName,String personalNumber) {
         if (firstName != null) {
            return studentRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return studentRepository.findByLastName(lastName);
        } else if (personalNumber != null) {
            return studentRepository.findByPersonalNumber(personalNumber);
        } else {
            return studentRepository.findAll();
        }
    }

}

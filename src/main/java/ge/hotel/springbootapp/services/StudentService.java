package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student editStudentInfo(Integer studentId, Student student);
    void deleteStudent(Integer Id);
    List<Student> search(String firstName,String LastName,String personalNumber);

}

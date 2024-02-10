package ge.hotel.springbootapp.controllers;

import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/edit/{studentId}")
    public Student editStudentInfo(@PathVariable Integer studentId, @RequestBody Student student) {
        return studentService.editStudentInfo(studentId, student);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) String personalNumber) {
        return studentService.search(firstName,lastName,personalNumber);
    }

}

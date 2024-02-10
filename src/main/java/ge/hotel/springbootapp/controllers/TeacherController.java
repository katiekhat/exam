package ge.hotel.springbootapp.controllers;
import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.entities.Teacher;
import ge.hotel.springbootapp.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("/edit/{teacherId}")
    public Teacher editTeacherInfo(@PathVariable Integer teacherId, @RequestBody Teacher teacher) {
        return teacherService.editTeacherInfo(teacherId, teacher);
    }

    @DeleteMapping("/delete/{teacherId}")
    public void deleteTeacher(@PathVariable Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    @GetMapping("/search")
    public List<Teacher> search(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) String personalNumber) {
        return teacherService.search(firstName,lastName,personalNumber);
    }
}

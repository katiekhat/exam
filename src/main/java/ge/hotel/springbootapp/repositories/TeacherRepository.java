package ge.hotel.springbootapp.repositories;

import ge.hotel.springbootapp.entities.Student;
import ge.hotel.springbootapp.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByFirstName(String firstName);

    List<Teacher> findByLastName(String lastName);

    List<Teacher> findByPersonalNumber(String personalNumber);
}

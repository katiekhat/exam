package ge.hotel.springbootapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="student_group")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="group_id")
    private Integer groupId;
    @Column(name="group_number")
    private int groupNumber;
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
//    @ManyToOne
//    @JoinColumn(name = "teacher_id")
//    private Teacher teacher;

    @ElementCollection
    @CollectionTable(name = "group_table", joinColumns = @JoinColumn(name = "group_id"))
    @Column(name = "student_id")
    private List<Integer> studentIds = new ArrayList<>();

    @Column(name = "teacher_id")
    private Integer teacherId;
}

package in.arpitgadle.services;


import in.arpitgadle.entities.Student;

import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    Optional<Student> getStudentById(Long studentId);

    void deleteStudent(Student student);
}

package in.arpitgadle.services;

import in.arpitgadle.entities.Student;
import in.arpitgadle.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl
    implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
    return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}

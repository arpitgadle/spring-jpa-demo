package in.arpitgadle.test.service;

import in.arpitgadle.entities.Student;
import in.arpitgadle.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @Test
    void testStudentSave()
    {
        Student student=new Student();
        student.setStudentId(1L);
        student.setStudentName("Arpit");
        student.setStudentTestScore(50);

        Student savedStudent=studentService.save(student);

        assertNotNull(savedStudent);
    }

    @Test
    void testFindStudentById()
    {
        Student student=new Student();
        student.setStudentId(1L);
        student.setStudentName("Arpit");
        student.setStudentTestScore(50);

        studentService.save(student);
        
        Optional<Student> optionalStudent=studentService.getStudentById(student.getStudentId());
        assertNotNull(optionalStudent.get());
    }

    @Test
    void testStudentUpdate()
    {
        Student student=new Student();
        student.setStudentId(1L);
        student.setStudentName("Arpit");
        student.setStudentTestScore(50);

        studentService.save(student);

        student.setStudentName("Arpit Gadle");
        student.setStudentTestScore(70);

        studentService.save(student);

        Optional<Student> optionalStudent=studentService.getStudentById(student.getStudentId());
        assertNotNull(optionalStudent.get());
        assertEquals(optionalStudent.get().getStudentName(),"Arpit Gadle");
    }

    @Test
    void testStudentDelete()
    {
        Student student=new Student();
        student.setStudentId(1L);
        student.setStudentName("Arpit");
        student.setStudentTestScore(50);

        studentService.save(student);

        Optional<Student> optionalStudent=studentService.getStudentById(student.getStudentId());
        assertNotNull(optionalStudent.get());

        studentService.deleteStudent(student);

        Optional<Student> deletedStudent=studentService.getStudentById(student.getStudentId());
        assertEquals(deletedStudent.isPresent(),false);
    }
}

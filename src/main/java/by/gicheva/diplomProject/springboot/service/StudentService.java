package by.gicheva.diplomProject.springboot.service;

import by.gicheva.diplomProject.springboot.model.Student;

import java.util.List;

/**
 * Created by Margarita Gicheva on 03.05.2017.
 */
public interface StudentService {
    Student findById(Long id);

    Student findByName(String firstName, String lastName);

    void saveStudent(Student Student);

    void updateStudent(Student Student);

    void deleteStudentById(Long id);

    void deleteAllStudents();

    List<Student> findAllStudents();

    boolean isStudentExist(Student Student);
}

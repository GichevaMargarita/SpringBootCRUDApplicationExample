package by.gicheva.diplomProject.springboot.service;

import by.gicheva.diplomProject.springboot.model.Student;

import java.util.List;

/**
 * Created by Margarita Gicheva on 04.05.2017.
 */
public  interface StudentService {
    Student findById(Long id);

    Student findByName(String name);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(Long id);

    void deleteAllStudents();

    List<Student> findAllStudents();

    boolean isStudentExist(Student student);
}

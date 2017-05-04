package by.gicheva.diplomProject.springboot.service;

import by.gicheva.diplomProject.springboot.model.Student;
import by.gicheva.diplomProject.springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Margarita Gicheva on 04.05.2017.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        saveStudent(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.delete(id);
    }

    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public boolean isStudentExist(Student student) {
        return findByName(student.getName()) != null;
    }
}

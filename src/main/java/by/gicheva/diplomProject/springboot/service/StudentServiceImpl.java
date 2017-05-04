package by.gicheva.diplomProject.springboot.service;

import by.gicheva.diplomProject.springboot.model.Student;
import by.gicheva.diplomProject.springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Margarita Gicheva on 03.05.2017.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    public Student findByName(String lastName) {
        return studentRepository.findByName(lastName);
    }

    public void saveStudent(Student Student) {
        studentRepository.save(Student);
    }

    public void updateStudent(Student Student){
        saveStudent(Student);
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
        return findByName(student.getLastName()) != null;
    }
}

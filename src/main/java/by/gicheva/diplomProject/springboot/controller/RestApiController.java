package by.gicheva.diplomProject.springboot.controller;

import java.util.List;

import by.gicheva.diplomProject.springboot.model.Student;
import by.gicheva.diplomProject.springboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import by.gicheva.diplomProject.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    StudentService studentService;

    // -------------------Retrieve All Students---------------------------------------------

    @RequestMapping(value = "/student/", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudents() {
        List<Student> students = studentService.findAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    // -------------------Create a Student-------------------------------------------

    @RequestMapping(value = "/student/", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Student : {}", student);

        if (studentService.isStudentExist(student)) {
            logger.error("Unable to create. A Student with name {} already exist", student.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Student with last name " +
                    student.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        studentService.saveStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Delete a Student-----------------------------------------

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Student with id {}", id);

        Student student = studentService.findById(id);
        if (student == null) {
            logger.error("Unable to delete. Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Update a Student ------------------------------------------------

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        logger.info("Updating Student with id {}", id);

        Student currentStudent = studentService.findById(id);

        if (currentStudent == null) {
            logger.error("Unable to update. Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Student with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setName(student.getName());
        currentStudent.setIdGroup(student.getIdGroup());

        studentService.updateStudent(currentStudent);
        return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
    }

    // -------------------Retrieve Single Student------------------------------------------

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@PathVariable("id") long id) {
        logger.info("Fetching Student with id {}", id);
        Student student = studentService.findById(id);
        if (student == null) {
            logger.error("Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Student with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
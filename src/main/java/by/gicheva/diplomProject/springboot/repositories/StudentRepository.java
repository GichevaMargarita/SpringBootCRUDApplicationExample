package by.gicheva.diplomProject.springboot.repositories;

import by.gicheva.diplomProject.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Margarita Gicheva on 03.05.2017.
 */
public interface StudentRepository extends JpaRepository <Student, Long> {

    Student findByName(String name);

}

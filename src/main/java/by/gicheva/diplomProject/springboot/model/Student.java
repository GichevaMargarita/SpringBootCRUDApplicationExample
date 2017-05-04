package by.gicheva.diplomProject.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Margarita Gicheva on 04.05.2017.
 */
@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Column(name="studentFirstName", nullable=false)
    private String firstName;
    @NotEmpty
    @Column(name="studentLastName", nullable=false)
    private String name;
    @NotEmpty
    @Column(name="studentIdGroup", nullable=false)
    private Integer idGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (idGroup != student.idGroup) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idGroup;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" +  name + '\'' +
                ", idGroup=" + idGroup +
                '}';
    }
}

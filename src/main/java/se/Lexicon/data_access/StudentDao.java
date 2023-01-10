package se.Lexicon.data_access;

import org.springframework.stereotype.Component;
import se.Lexicon.Exception.DataNotFoundException;
import se.Lexicon.models.Student;

import java.util.List;

@Component
public interface StudentDao {

    Student save(Student student);

    Student find(int studentId) throws DataNotFoundException;

    List<Student> findAll();

    void delete(int studentId) throws DataNotFoundException;


}

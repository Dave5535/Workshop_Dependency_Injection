package se.Lexicon.data_access;


import org.springframework.stereotype.Component;
import se.Lexicon.Exception.DataNotFoundException;
import se.Lexicon.Sequencer.StudentIdGenerator;
import se.Lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
@Component
public class StudentDaoListImpl implements StudentDao {

   List<Student> storage = new ArrayList<>();


    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student information was null");
        Student createdStudent = new Student(student.getName());
int studentId = StudentIdGenerator.generateStudentNumber();
        createdStudent.setId(studentId);
        storage.add(createdStudent);
        return createdStudent;
    }

    @Override
    public Student find(int studentId) throws DataNotFoundException {
Student student = null;
       if (studentId == 0  || studentId < 0  ) throw new IllegalArgumentException("Invalid Id entered ");
        for (Student foundStudent : storage){
            if (foundStudent.getId()== studentId)
                student = foundStudent;

        }
        if (student == null)throw new DataNotFoundException("Id had no Data");
       return student;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void delete(int studentId) throws DataNotFoundException {
storage.remove(find(studentId));
    }
}

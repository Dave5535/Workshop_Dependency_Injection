package se.Lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.Lexicon.AppConfig.ComponentScanConfig;
import se.Lexicon.Exception.DataNotFoundException;
import se.Lexicon.data_access.StudentDao;
import se.Lexicon.data_access.StudentDaoListImpl;
import se.Lexicon.models.Student;


public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);


        System.out.println(studentDao.save(new Student("David"))); // save

        try {                                                     // delete
            studentDao.delete(1);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());;
        }

        System.out.println(studentDao.findAll());                 // findAll

        try {                                                        // find
            System.out.println(studentDao.find(1));
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }
}

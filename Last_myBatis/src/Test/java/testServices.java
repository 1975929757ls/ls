import com.mylast.domain.Students;
import com.mylast.services.StudentServices;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testServices {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        StudentServices studentServices= (StudentServices) ac.getBean("studentServices");
        List<Students> students=studentServices.findall();
        for (Students student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentServices students= (StudentServices) context.getBean("studentServices");
        Students students1=students.findBynameAndpassword("pw","1234");
        System.out.println(students1);
    }
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentServices students= (StudentServices) context.getBean("studentServices");
        Students students1=students.findBynameAndpassword("pw","1234");
        students1.setPhone("150");
        students.update(students1);
        System.out.println(students1);
    }
}

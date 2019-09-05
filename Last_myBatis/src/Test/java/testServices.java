import com.mylast.domain.Course;
import com.mylast.domain.Grades;
import com.mylast.domain.Students;
import com.mylast.domain.studentClass;
import com.mylast.services.CourseServices;
import com.mylast.services.GradesServices;
import com.mylast.services.StudentClassServices;
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
    public void test11(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        GradesServices gradesServices=(GradesServices) ac.getBean("gradesServices");
        List<Grades> grades=gradesServices.find();
        for (Grades grades1 : grades) {
            System.out.println(grades1);
        }
    }
    @Test
    public void testinsert(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        GradesServices gradesServices=(GradesServices) ac.getBean("gradesServices");
        Grades grades=new Grades();
        grades.setCourseID(4);
        grades.setStudentID(418);
        grades.setCourseName("数据结构");
        grades.setNum(100);
        grades.setTeachername("李建成");
        grades.setStudentname("蒙发");
        gradesServices.add(grades);
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
        Students students1=students.findBynameAndpassword("蒙发","1234");
        students1.setPhone("15877566090");
        students.update(students1);
        System.out.println(students1);
    }
    @Test
    public  void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CourseServices courseServices = (CourseServices) context.getBean("courseServices");
        StudentClassServices studentClassServices = (StudentClassServices) context.getBean("studentClassServices");
        List<Integer> cid = studentClassServices.findid(416);
        for (Integer integer : cid) {
            System.out.println(integer);
        }
        Course course=null;
        List<Course> courseList=null;
        for(int i=0;i<cid.size();i++){
             course=courseServices.findbyCourseID(cid.get(i));
             //courseList.add(courseServices.findbyCourseID(cid.get(i)));
        }
        System.out.println(course);
    }
}

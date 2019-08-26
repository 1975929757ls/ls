
import com.mylast.dao.IUserDao;
import com.mylast.dao.StudentsDao;
import com.mylast.domain.Students;
import com.mylast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    InputStream in = Resources.getResourceAsStream("MyBatis1.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    SqlSession session = factory.openSession();

    public test() throws IOException {
    }

    @Test
    public void test1() throws IOException {
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findall();
        session.commit();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }

    @Test
    public void test2() throws IOException {
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        List<Students> students = studentsDao.findall();
        for (Students student : students) {
            System.out.println(student);
        }
        session.close();
        in.close();
    }

    @Test
    public void test3() throws IOException {
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        Students students = studentsDao.findBstudentsID(416);
        System.out.println(students);
        session.close();
        in.close();
    }

    @Test
    public void test4() throws IOException {
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        Students students = studentsDao.findBynameAndstudentID("pw", 418, "1234");
        System.out.println(students);
        session.close();
        in.close();
    }

    @Test
    public void test5() throws IOException {
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        Students students = new Students();
        students.setStudentID(419);
        students.setName("Ls");
        students.setPassword("1234");
        students.setSex("男");
        students.setColege("计算机科学学院");
        students.setMajor("软件工程");
        students.setPhone("150");
        studentsDao.insertStudent(students);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testdel() {
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        studentsDao.delete(419);
        session.commit();
    }

    @Test
    public void testUP() {
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        Students students = new Students();
        students.setStudentID(418);
        students.setName("pw");
        students.setPassword("1234");
        students.setSex("男");
        students.setColege("计算机科学学院");
        students.setMajor("计算机网络");
        students.setPhone("120");
        studentsDao.update(students);
        session.commit();
        session.close();
    }
    @Test
    public void tests(){
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        List<Students> students=studentsDao.findlike("%p%");
        for (Students student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testsl(){
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        List<Students> students=studentsDao.findlike1("p");
        for (Students student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testCount(){
        StudentsDao studentsDao = session.getMapper(StudentsDao.class);
        int number=studentsDao.Number();
        System.out.println(number);
    }

}

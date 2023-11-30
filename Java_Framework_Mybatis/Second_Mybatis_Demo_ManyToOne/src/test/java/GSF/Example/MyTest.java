package GSF.Example;

import GSF.Example.Dao.UserDao;
import GSF.Example.Pojo.Student;
import GSF.Example.Pojo.Teacher;
import GSF.Example.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void GetTeacherById() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlsession.close();

    }

    @Test
    public void GetStudent() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlsession.close();
    }

    @Test
    public void GetStudent2() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        List<Student> students = mapper.getStudent2();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlsession.close();
    }
}
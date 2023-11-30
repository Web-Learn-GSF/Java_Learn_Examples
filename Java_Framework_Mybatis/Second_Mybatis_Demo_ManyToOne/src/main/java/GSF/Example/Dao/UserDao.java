package GSF.Example.Dao;

import GSF.Example.Pojo.Student;
import GSF.Example.Pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface UserDao {
    Teacher getTeacher(int id);

    List<Student> getStudent();

    List<Student> getStudent2();

}

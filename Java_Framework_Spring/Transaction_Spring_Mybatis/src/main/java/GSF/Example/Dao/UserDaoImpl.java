package GSF.Example.Dao;

import GSF.Example.Pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    @Override
    public User getUserById(int id) {

        User user = new User(id, "测试事务", "123235");
        UserDao mapper = getSqlSession().getMapper(UserDao.class);

        mapper.addUser(user);
        mapper.deleteUser(id);

        return mapper.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserDao.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserDao.class).deleteUser(id);
    }

}

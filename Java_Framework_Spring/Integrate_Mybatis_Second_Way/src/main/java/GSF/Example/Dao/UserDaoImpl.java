package GSF.Example.Dao;

import GSF.Example.Pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    @Override
    public List<User> getUserList() {
        return getSqlSession().getMapper(UserDao.class).getUserList();
    }

    @Override
    public User getUserById(int id) {
        return getSqlSession().getMapper(UserDao.class).getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserDao.class).addUser(user);
    }

    @Override
    public int addUserByMap(Map<String, Object> map) {
        return getSqlSession().getMapper(UserDao.class).addUserByMap(map);
    }

    @Override
    public int updateUser(User user) {
        return getSqlSession().getMapper(UserDao.class).updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserDao.class).deleteUser(id);
    }
}

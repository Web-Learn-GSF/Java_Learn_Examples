package GSF.Example.Dao;

import GSF.Example.Pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao{
    // 注入sqlSession
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserList() {
        return sqlSession.getMapper(UserDao.class).getUserList();
    }

    @Override
    public User getUserById(int id) {
        return sqlSession.getMapper(UserDao.class).getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return sqlSession.getMapper(UserDao.class).addUser(user);
    }

    @Override
    public int addUserByMap(Map<String, Object> map) {
        return sqlSession.getMapper(UserDao.class).addUserByMap(map);
    }

    @Override
    public int updateUser(User user) {
        return sqlSession.getMapper(UserDao.class).updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return sqlSession.getMapper(UserDao.class).deleteUser(id);
    }
}

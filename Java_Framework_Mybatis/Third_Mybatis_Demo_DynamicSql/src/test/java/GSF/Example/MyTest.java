package GSF.Example;

import GSF.Example.Dao.UserDao;
import GSF.Example.Pojo.Blog;
import GSF.Example.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void GetBlogIf() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Map<String, Object> objectMap = new HashMap<>();

        //注释掉，就返回默认检索的所有情况
        objectMap.put("title", "如何学Django");
        objectMap.put("author", "刘");

        List<Blog> blogIf = mapper.getBlogIf(objectMap);
        for (Blog blog : blogIf) {
            System.out.println(blog);
        }

        sqlsession.close();

    }

    @Test
    public void GetBlogChoose_When_Otherwise() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Map<String, Object> objectMap = new HashMap<>();

        //注释掉，就返回默认检索的所有情况
        //objectMap.put("title", "如何学Django");
        //objectMap.put("author", "刘");

        List<Blog> blogIf = mapper.getBlogChoose_When_Otherwise(objectMap);
        for (Blog blog : blogIf) {
            System.out.println(blog);
        }

        sqlsession.close();

    }


    @Test
    public void UpdateBlogSet() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("id", 1);
        objectMap.put("title", "如何学Python-修改");
        objectMap.put("author", "刘");

        int blogIf = mapper.updateBlogSet(objectMap);
        System.out.println(blogIf);

        sqlsession.commit();
        sqlsession.close();

    }

    // 使用trim标签和SQL片段
    @Test
    public void UpdateBlogTrim_SQLFragment() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("id", 1);
        objectMap.put("title", "如何学Python-修改");
        objectMap.put("author", "青-修改-修改");

        int blogIf = mapper.updateBlogTrim(objectMap);
        System.out.println(blogIf);

        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void GetBlogForeach() {

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        //ids.add(4);

        HashMap<String, Object> map = new HashMap<>();
        map.put("ids", ids);

        List<Blog> blogIf = mapper.getBlogForeach(map);
        for (Blog blog : blogIf) {
            System.out.println(blog);
        }

        sqlsession.close();

    }
}
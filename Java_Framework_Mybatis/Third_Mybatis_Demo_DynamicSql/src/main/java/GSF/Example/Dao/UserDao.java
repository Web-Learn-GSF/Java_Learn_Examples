package GSF.Example.Dao;

import GSF.Example.Pojo.Blog;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Blog> getBlogIf(Map<String, Object> map);
    List<Blog> getBlogChoose_When_Otherwise(Map<String, Object> map);

    int updateBlogSet(Map<String, Object> map);
    int updateBlogTrim(Map<String, Object> map);

    List<Blog> getBlogForeach(Map<String, Object> map);
}

package dao;




import jdbctemplate.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import servlet.User;

import java.util.Map;

/**
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public UserDao() {

    }

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,没有查询到，返回null
     */
    public User login(User loginUser){

        try {
            //1.编写sql
            String sql = "select * from userlogin where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean IfReapeat(String name){
        try {
            String sql = "select id from userlogin where username = ?";
            Map<String, Object> rs = template.queryForMap(sql, name);
            return false;
        }catch (Exception e){
            return true;
        }


    }

    public int Regist(String username , String password){
        String sql = "insert into userlogin(username,password) values(?,?,?)";
        int count = template.update(sql,  username, password);
        return count;
    }
    public int uploadData(int UID,String time){
        String sql = "insert into uploadmessage(uploadTime,UserID) values(?,?)";
        int count = template.update(sql,  time, UID);
        return count;
    }
}
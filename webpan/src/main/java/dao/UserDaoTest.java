package dao;


import org.junit.Test;
import servlet.User;

public class UserDaoTest {



    @Test
    public void testLogin(){
        User loginuser = new User("1","1");



        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}

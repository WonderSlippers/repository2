package servlet;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        String Rusername = request.getParameter("Rusername");
        String Rpassword = request.getParameter("Rpassword");
        UserDao dao = new UserDao();
       if( dao.IfReapeat(Rusername)){
           dao.Regist(Rusername,Rpassword);
       }
       else {
           PrintWriter writer = response.getWriter();
           writer.write("此用户名以被占用！");
           writer.flush();
       }
    }
}

package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/fileServlet")
public class FolderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查是否为登录状态
        HttpSession session= request.getSession();
        if(session.getAttribute("user")==null){
            response.sendRedirect("/login.jsp");
        }
        //注销功能
        if(request.getParameter("注销")=="注销") {
            session.setAttribute("user", null);
        }

        if(session.getAttribute("user")==null){
            response.sendRedirect("/login.jsp");}



        String nowPath =(String) request.getAttribute("nowPath");
        String foldername = request.getParameter("foldername");

        String FolderPath = request.getServletContext().getRealPath("./") + File.separator + foldername;


        // 如果目录不存在则创建
        File FolderDir = new File(FolderPath);
        if (!FolderDir.exists()) {
            FolderDir.mkdir();

        }
        else {
            request.setAttribute("rp_error","文件夹已存在");
            //转发到登录页面
            request.getRequestDispatcher("/.jsp").forward(request,response);
        }

    }
}
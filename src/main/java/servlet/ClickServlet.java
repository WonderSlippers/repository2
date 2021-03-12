package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ClickServlet", value = "/ClickServlet")
public class ClickServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String clickFilePath = (String) session.getAttribute("ClickFile");
        File ClickFile=new File(clickFilePath);
        File[] files = ClickFile.listFiles();
        request.setAttribute("Files",files);
        request.getRequestDispatcher("/Menu.jsp").forward(request,response);

    }
}
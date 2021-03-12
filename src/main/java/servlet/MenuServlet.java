package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "MenuServlet", value = "/MenuServlet")
public class MenuServlet extends HttpServlet {
    //分页方法
    public static <T> List<List<T>> getSplitList(int splitNum, List<T> list) {
        List<List<T>> splitList = new LinkedList<>();
        // groupFlag >= 1
        int groupFlag = list.size() % splitNum == 0 ? (list.size() / splitNum) : (list.size() / splitNum + 1);
        for (int j = 1; j <= groupFlag; j++) {
            if ((j * splitNum) <= list.size()) {
                splitList.add(list.subList(j * splitNum - splitNum, j * splitNum));
            } else if ((j * splitNum) > list.size()) {
                splitList.add(list.subList(j * splitNum - splitNum, list.size()));
            }
        }
        return splitList;
    }

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

        User user =(User) request.getAttribute("user");
        int PageNumber=(int)request.getAttribute("pageNumber");
        String username = user.getUsername();
        File UnderName= new File(request.getServletContext().getRealPath("./") + File.separator + username);
        File[] files = UnderName.listFiles();
        List<File> resultList= new ArrayList<File>(Arrays.asList(files));
        //  分页，一次只给4个文件和当前页数
        List<List<File>> nowFilePage = getSplitList(4, resultList);


        request.setAttribute("Files",nowFilePage.get(PageNumber));
        request.setAttribute("page",PageNumber);
        request.getRequestDispatcher("/Menu.jsp").forward(request,response);


    }
}
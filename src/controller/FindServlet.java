package controller;

import service.Impl.UserServiceImpl;
import service.abst.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/HandleFind")
public class FindServlet extends HttpServlet {
    public FindServlet() {
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String Uname = req.getParameter("username").trim();
        String safeanwser = req.getParameter("safeanwser").trim();
        UserService us=new UserServiceImpl();
        ResultSet rt= null;//获取查询结果
        //System.out.println("长度："+Uname.length());
        if (Uname.length()>255 || safeanwser.length()>255){
            resp.sendRedirect("page/find.jsp?FindError=fail");
            return;
        }
        try {
            rt = us.find(Uname);
            if (rt.next()){

                String safeanwser_rt=rt.getString("safeanwser");
                String isdelete=rt.getString("isdelete");
                //System.out.println(safeanwser_rt+isdelete);
                if (Objects.equals(safeanwser_rt, safeanwser)){//通过验证

                    req.setAttribute("pname", rt.getString("Uname"));
                    req.getRequestDispatcher("page/modify.jsp").forward(req, resp);

                } else if (Objects.equals(isdelete, "yes")){//被封禁
                    resp.sendRedirect("page/find.jsp?FindError=ban");
                }else {//验证失败
                    resp.sendRedirect("page/find.jsp?FindError=fail");
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}

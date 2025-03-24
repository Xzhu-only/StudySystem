package controller;

import service.Impl.TeacherServiceImpl;
import service.Impl.UserServiceImpl;
import service.abst.TeacherService;
import service.abst.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HandleTeacherRegister")
public class TeacherRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String Tname = req.getParameter("username").trim();
        String Tpassword = req.getParameter("password").trim();
        String password2 = req.getParameter("password2").trim();
        String prone = req.getParameter("prone").trim();
        String introduce = req.getParameter("introduce").trim();

        boolean boo = Tname.length() > 0 && Tpassword.length() > 0;
        if (!boo){
            resp.sendRedirect("page/teacher/register.jsp?TRegisterError=Nothing");
            return;
        }
        if(Tpassword.equals(password2)){
            TeacherService ts=new TeacherServiceImpl();
            try {
                boolean temp=ts.register(Tname,Tpassword,prone,introduce);//获取查询结果
                if(temp){//插入成功
                    resp.sendRedirect("page/teacher/register.jsp?TRegisterError=success");
                }else {//插入失败
                    resp.sendRedirect("page/teacher/register.jsp?TRegisterError=IsExist");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {//两次密码不同
            resp.sendRedirect("page/teacher/register.jsp?TRegisterError=WrongP2");
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

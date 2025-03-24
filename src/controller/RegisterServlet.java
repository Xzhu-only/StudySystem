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

@WebServlet("/HandleRegister")
public class RegisterServlet extends HttpServlet {

    public RegisterServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 获取注册类型
        String type = req.getParameter("type").trim();
        UserService us = new UserServiceImpl();
        TeacherService ts = new TeacherServiceImpl();
        try {
            switch (type) {
                case "student": // 学生注册
                    handleStudentRegister(req, resp, us);
                    break;
                case "teacher": // 教师注册
                    handleTeacherRegister(req, resp, ts);
                    break;
                default: // 未知类型
                    resp.sendRedirect("/page/register.jsp?RegisterError=UnknownType");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 处理学生注册逻辑
    private void handleStudentRegister(HttpServletRequest req, HttpServletResponse resp, UserService us) throws IOException {
        String Uname = req.getParameter("username").trim();
        String Upassword = req.getParameter("password").trim();
        String Major = req.getParameter("major").trim();
        String Classname = req.getParameter("classname").trim();
        String password2 = req.getParameter("password2").trim();
        String commits = req.getParameter("commits").trim();
        String safeanwser = req.getParameter("safeanwser").trim();

        boolean isValidInput = Uname.length() > 0 && Upassword.length() > 0;
        if (!isValidInput) {
            resp.sendRedirect("/page/register.jsp?RegisterError=Nothing");
            return;
        }

        if (Upassword.equals(password2)) {
            boolean isRegistered = us.register(Uname, Upassword, Major, Classname, commits, safeanwser);
            if (isRegistered) {
                resp.sendRedirect("/page/register.jsp?RegisterError=success");


            } else {
                resp.sendRedirect("/page/register.jsp?RegisterError=IsExist");
            }
        } else {
            resp.sendRedirect("/page/register.jsp?RegisterError=WrongP2");
        }
    }

    // 处理教师注册逻辑
    private void handleTeacherRegister(HttpServletRequest req, HttpServletResponse resp, TeacherService ts) throws IOException {

        String Tname = req.getParameter("name").trim();
        String Tpassword = req.getParameter("password").trim();
        String Tphone = req.getParameter("phone").trim();
        String Tinfo = req.getParameter("info").trim();
        String password2 = req.getParameter("password2").trim();

        boolean isValidInput = Tname.length() > 0 && Tpassword.length() > 0 && Tphone.length() > 0;
        if (!isValidInput) {
            resp.sendRedirect("/page/teacher/register.jsp?RegisterError=Nothing");
            return;
        }

        if (Tpassword.equals(password2)) {
            boolean isRegistered = ts.register(Tname, Tpassword, Tphone, Tinfo);
            if (isRegistered) {
                resp.sendRedirect("/page/teacher/register.jsp?RegisterError=success");
            } else {
                resp.sendRedirect("/page/teacher/register.jsp?RegisterError=IsExist");
            }
        } else {
            resp.sendRedirect("/page/teacher/register.jsp?RegisterError=WrongP2");
        }
    }
}

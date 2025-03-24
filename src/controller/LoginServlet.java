package controller;


import javaBean.TeacherBean;
import service.Impl.AdminServiceImpl;
import service.Impl.TeacherServiceImpl;
import service.Impl.UserServiceImpl;
import service.abst.AdminService;
import service.abst.TeacherService;
import service.abst.UserService;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet({"/HandleLogin"})
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    public void destroy() {super.destroy();}
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Servlet invoked");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        String type = req.getParameter("type").trim();
//        System.out.println(name+"#"+password+"#"+type);
        boolean boo = name.length() > 0 && password.length() > 0;//账户密码不为空
        if (boo) {
            switch (type) {
                case "user":
                    UserService us = new UserServiceImpl();
                    try {
                        ResultSet rt = us.login(name);//获取查询结果
                        if (!rt.next()) {//查不到数据
                            resp.sendRedirect("page/login.jsp?LoginError=WrongName");
                        } else {
                            String Upassword_rt = rt.getString("Upassword");
                            String isdelete = rt.getString("isdelete");
                            if (!Objects.equals(Upassword_rt, password)) {//密码错误
                                resp.sendRedirect("page/login.jsp?LoginError=WrongPass");
                            } else if (Objects.equals(isdelete, "yes")) {//被封禁
                                resp.sendRedirect("page/login.jsp?LoginError=ban");
                            } else {//登录成功
                                req.getSession().setAttribute("uname", name);
                                req.getRequestDispatcher("index.jsp").forward(req, resp);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "teacher": // 教师角色
                    TeacherService ts = new TeacherServiceImpl();
                    try {
                        TeacherBean teacher = ts.login(name); // 获取教师信息
                        if (teacher == null) {
                            resp.sendRedirect("page/login.jsp?TeacherLoginError=WrongName");
                        } else {
                            if (!Objects.equals(teacher.getTpassword(), password)) {
                                resp.sendRedirect("page/login.jsp?TeacherLoginError=WrongPass");
                            } else if (Objects.equals(teacher.getIsdelete(), "yes")) {
                                resp.sendRedirect("page/login.jsp?TeacherLoginError=ban");
                            } else {
                                // 登录成功，将教师信息设置到 Session
                                HttpSession session = req.getSession();
                                session.setAttribute("Tname", name);          // 设置教师名称
                                session.setAttribute("tid", teacher.getTid()); // 设置教师 ID (教师的 ID 存储到 session)
                                System.out.println("Teacher ID after login: " + teacher.getTid());

                                // 跳转到教师的主页
                                req.getRequestDispatcher("/page/teacher/TeacherFirst.jsp").forward(req, resp);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "admin": //管理员角色
                    AdminService as = new AdminServiceImpl();
                    try {

                        ResultSet rt = as.login(name);//获取查询结果
                        if (!rt.next()) {//查不到数据
                            resp.sendRedirect("page/login.jsp?ALError=WrongName");
                        } else {//有数据
                            String Apassword_rt = rt.getString("Apassword");
                            if (!Objects.equals(Apassword_rt, password)) {//密码错误
                                resp.sendRedirect("page/login.jsp?ALError=WrongPass");
                            } else {//登录成功
                                resp.sendRedirect("page/login.jsp?ALError=Success");
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
        else {//提交空表
            resp.sendRedirect("page/login.jsp?LoginError=nothing");
        }


    }
}

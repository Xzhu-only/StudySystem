package controller;

import Dao.abst.CourseDao;
import javaBean.CourseBean;
import javaBean.TeacherBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherinfo")
public class TeacherController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherBean teacher = getTeacherFromSession(request); // 从session中获取教师信息
        if (teacher != null) {
            request.setAttribute("teacherName", teacher.getTname());
            request.getRequestDispatcher("teacherinfo.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // 如果没有登录，重定向到登录页面
        }
    }

    // 获取session中的教师信息
    private TeacherBean getTeacherFromSession(HttpServletRequest request) {
        return (TeacherBean) request.getSession().getAttribute("teacher"); // 假设教师信息存储在session中的"teacher"属性里
    }
}





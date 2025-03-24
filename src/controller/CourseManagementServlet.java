package controller;

import Dao.abst.CourseDao;
import Dao.impl.CourseDaoimpl;
import javaBean.CourseBean;
import javaBean.TeacherBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/courseManagement")
public class CourseManagementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 session 中的 teacherId
        HttpSession session = request.getSession();
        Integer teacherId = (Integer) session.getAttribute("tid");
        System.out.println("###");
        System.out.println(teacherId);


        if (teacherId == null || teacherId == 0) {
            // 如果没有 teacherId，则表示用户未登录，跳转到登录页面
            response.sendRedirect("login.jsp?error=notLoggedIn");
            return;
        }

        // 获取表单提交的数据
        String action = request.getParameter("action"); // 获取操作类型（如添加、删除等）

        if ("addCourse".equals(action)) {
            // 添加课程
            String courseName = request.getParameter("courseName");
            String courseDescription = request.getParameter("courseDescription");
            // 获取其他课程信息（如课程描述、学分等）

            // 验证输入数据
            if (courseName == null || courseName.trim().isEmpty()) {
                request.setAttribute("error", "课程名称不能为空");
                request.getRequestDispatcher("/page/teacher/courseManage.jsp").forward(request, response);
                return;
            }

            // 创建 CourseBean 对象并设置属性
            CourseBean course = new CourseBean();
            course.setCourname(courseName);
            course.setIntroduce(courseDescription);
            course.setTid(teacherId); // 设置当前教师ID

            // 调用 DAO 层方法将课程添加到数据库
            CourseDao courseDao = new CourseDaoimpl();
            boolean result = courseDao.addCourse(course,teacherId);

            if (result) {
                // 添加成功后跳转到课程管理页面
                response.sendRedirect("courseManagement");
            } else {
                // 如果添加失败，返回错误信息
                request.setAttribute("error", "课程添加失败");
                request.getRequestDispatcher("/page/teacher/courseManage.jsp").forward(request, response);
            }
        } else if ("deleteCourse".equals(action)) {
            // 删除课程
            String courseIdStr = request.getParameter("courseId");
            if (courseIdStr == null || courseIdStr.trim().isEmpty()) {
                request.setAttribute("error", "课程ID不能为空");
                request.getRequestDispatcher("/page/teacher/courseManage.jsp").forward(request, response);
                return;
            }

            int courseId = Integer.parseInt(courseIdStr);

            // 调用 DAO 层方法删除课程
            CourseDao courseDao = new CourseDaoimpl();
            boolean result = courseDao.deleteCourse(courseId);

            if (result) {
                // 删除成功后跳转到课程管理页面
                response.sendRedirect("courseManagement");
            } else {
                // 删除失败，返回错误信息
                request.setAttribute("error", "课程删除失败");
                request.getRequestDispatcher("/page/teacher/courseManage.jsp").forward(request, response);
            }
        } else {
            // 如果没有匹配的操作类型，跳转到默认的课程管理页面
            response.sendRedirect("courseManagement");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 session 中的 teacherId
        HttpSession session = request.getSession();
        Integer teacherId = (Integer) session.getAttribute("tid");
        System.out.println(teacherId);
        if (teacherId != null && teacherId != 0) {
            // 使用 teacherId 查询该教师的所有课程
            CourseDao courseDao = new CourseDaoimpl();
            List<CourseBean> courses = courseDao.getCoursesByTeacherId(teacherId);

            // 将课程列表传递给前端页面
            request.setAttribute("courseList", courses);

            // 转发到课程管理页面（JSP 页面）
            request.getRequestDispatcher("/page/teacher/courseManage.jsp").forward(request, response);
        } else {
            // 如果没有 teacherId，则表示用户未登录，跳转到登录页面或提示错误
            response.sendRedirect("login.jsp");
        }
    }
}

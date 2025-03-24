package controller;

import Dao.abst.CourseDao;
import Dao.impl.CourseDaoimpl;
import service.abst.CourseService;
import service.Impl.CourseServiceImpl;
import javaBean.CourseBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取教师ID
        Integer teacherId = (Integer) request.getSession().getAttribute("tid");
        System.out.println("***");
        System.out.println(teacherId);
        if (teacherId == null) {
            request.setAttribute("message", "教师ID未登录或未设置，请重新登录！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // 获取该教师的课程信息
        CourseDao courseDao = new CourseDaoimpl();
        List<CourseBean> courses = courseDao.getCoursesByTeacherId(teacherId);

        // 设置属性并转发到 addCourse.jsp
        request.setAttribute("teacherCourses", courses);
        request.getRequestDispatcher("/page/teacher/courseManage.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");

        // 获取表单数据
        String cname = request.getParameter("Cname");
        String category = request.getParameter("category");
        String grade = request.getParameter("grade");
        String introduce = request.getParameter("introduce");
        System.out.println(cname);
        System.out.println(category);
        System.out.println(grade);
        System.out.println(introduce);

        // 获取教师 ID（从 session 中）
        Integer teacherId = (Integer) request.getSession().getAttribute("tid");

        if (teacherId == null || teacherId == 0) {
            System.out.println("Invalid teacherId in session.");
            // 处理错误情况
        }

        if (teacherId == null) {
            request.setAttribute("message", "教师未登录，请重新登录！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // 校验数据
        if (cname == null || cname.isEmpty() || category == null || category.isEmpty() || grade == null || grade.isEmpty() || introduce == null || introduce.isEmpty()) {
            request.setAttribute("message", "所有字段不能为空！");
            request.getRequestDispatcher("/page/teacher/addCourse.jsp").forward(request, response);
            return;
        }

        // 创建课程对象并保存
        CourseBean course = new CourseBean();
        course.setCourname(cname);
        course.setCategory(category);
        course.setGrade(grade);
        course.setIntroduce(introduce);

        // 调用服务层保存课程数据，传入 teacherId
        CourseService courseService = new CourseServiceImpl();
        boolean isAdded = courseService.addCourse(course, teacherId);  // 传递 teacherId

        // 如果添加成功
        if (isAdded) {
            request.setAttribute("message", "课程添加成功！");
        } else {
            request.setAttribute("message", "课程添加失败，请重试！");
        }

        // 获取该教师的所有课程
        CourseDao courseDao = new CourseDaoimpl();
        List<CourseBean> courses = courseDao.getCoursesByTeacherId(teacherId);

        // 将课程列表传递给页面
        request.setAttribute("courseList", courses);

        System.out.println("Query Result**: " + courses);

        // 跳转到课程管理页面
        request.getRequestDispatcher("/page/teacher/TeacherFirst.jsp").forward(request, response);
    }
}

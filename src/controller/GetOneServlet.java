package controller;

import javaBean.AdminBean;
import javaBean.TeacherBean;
import javaBean.UserBean;
import javaBean.VideoBean;
import service.Impl.AdminServiceImpl;
import service.Impl.TeacherServiceImpl;
import service.Impl.UserServiceImpl;
import service.Impl.VideoServiceImpl;
import service.abst.AdminService;
import service.abst.TeacherService;
import service.abst.UserService;
import service.abst.VideoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HandleGetOne")
public class GetOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type=req.getParameter("type");

        switch (type) {
            case "user":
                String uname = req.getParameter("uname");
                UserService us=new UserServiceImpl();
                UserBean ub= null;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    ub = us.getOne(uname);
                    req.setAttribute("userOne", ub);
                    req.getRequestDispatcher("/page/admin/moduser.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "teacher":
                String tname = req.getParameter("tname");
                TeacherService ts = new TeacherServiceImpl();
                TeacherBean tb;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    tb = ts.getOne(tname);
                    req.setAttribute("teacherOne", tb);
                    req.getRequestDispatcher("/page/admin/modteacher.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "admin":
                String aname = req.getParameter("aname");
                AdminService as=new AdminServiceImpl();
                AdminBean ab= null;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    ab = as.getOne(aname);
                    req.setAttribute("adminOne", ab);
                    req.getRequestDispatcher("/page/admin/modadmin.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "video":
                String vname = req.getParameter("vname");
                VideoService vs=new VideoServiceImpl();
                VideoBean vb= null;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    vb = vs.getOne(vname);
                    req.setAttribute("videoOne", vb);
                    req.getRequestDispatcher("/page/admin/modvideo.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "video1":
                String vname2 = req.getParameter("vname");
                VideoService vs1=new VideoServiceImpl();
                VideoBean vb1= null;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    vb = vs1.getOne(vname2);
                    req.setAttribute("videoOne", vb1);
                    req.getRequestDispatcher("/page/teacher/modvideo.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "comment":
                System.out.println();
                break;
            case "user1":
                String uname1 = req.getParameter("uname");
                UserService us1=new UserServiceImpl();
                UserBean ub1= null;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    ub1 = us1.getOne(uname1);
                    req.setAttribute("userOne", ub1);
                    req.getRequestDispatcher("/page/userinfo.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "usermod":
                String unamem = req.getParameter("uname");
                UserService usm=new UserServiceImpl();
                UserBean ubm= null;//获取查询结果
                //拿到id后查询这条数据，转到修改页，修改后发送修改请求
                try {
                    ubm = usm.getOne(unamem);
                    req.setAttribute("userOne", ubm);
                    req.getRequestDispatcher("/page/allmodify.jsp").forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "teacher1":
                String tname1 = req.getParameter("tname");  // 获取 Tname 参数
                TeacherService ts1 = new TeacherServiceImpl();
                TeacherBean tb1 = null;  // 创建 TeacherBean 对象，用于存储查询结果

                try {
                    // 查询教师信息
                    TeacherBean teacher = ts1.getOne(tname1);
                    // 如果没有查询到数据，跳转到 error 页面
                    if (teacher == null) {
                        req.getRequestDispatcher("/error.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("teacherOne", teacher);
                        req.getRequestDispatcher("/page/teacher/teacherinfo.jsp").forward(req, resp);
                    }
                } catch (Exception e) {
                    // 记录异常并转发到错误页面
                    e.printStackTrace();
                    req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
                }
                break;
            case "teachermod":
                String tnamem = req.getParameter("Tname");  // 获取 Tname 参数
                TeacherService tsm = new TeacherServiceImpl();
                TeacherBean tbm = null;  // 创建 TeacherBean 对象，用于存储查询结果

                try {
                    // 查询教师信息
                    TeacherBean teacher = tsm.getOne(tnamem);
                    System.out.println("&&&&&");
                    System.out.println(teacher);
                    // 如果没有查询到数据，跳转到 error 页面
                    if (teacher == null) {
                        req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("teacherOne", teacher);
                        req.getRequestDispatcher("/page/teacher/modteacher.jsp").forward(req, resp);
                    }
                } catch (Exception e) {
                    // 记录异常并转发到错误页面
                    e.printStackTrace();
                    req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
                }
                break;

        }


    }
}

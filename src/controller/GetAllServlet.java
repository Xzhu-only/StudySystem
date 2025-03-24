package controller;

import javaBean.*;
import service.Impl.*;
import service.abst.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/HandleGetAll")
public class GetAllServlet extends HttpServlet {
    public GetAllServlet() {
    }

    @Override
    public void destroy() {
        super.destroy();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        switch (type) {
            case "user":
                UserService us = new UserServiceImpl();
                List<UserBean> userList;
                try {
                    userList = us.getAll();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("userList", userList);
                req.getRequestDispatcher("/page/admin/showuser.jsp").forward(req, resp);
                break;
            case "teacher":
                TeacherService ts = new TeacherServiceImpl();
                List<TeacherBean> teacherList;
                try {
                    teacherList = ts.getAll();
                    System.out.println("教师列表数据：" + teacherList);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("teacherList", teacherList);
                req.getRequestDispatcher("/page/admin/showteacher.jsp").forward(req, resp);
                break;
            case "admin":
                AdminService as = new AdminServiceImpl();
                List<AdminBean> adminList;
                try {
                    adminList = as.getAll();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("adminList", adminList);
                req.getRequestDispatcher("/page/admin/showadmin.jsp").forward(req, resp);
                break;
            case "video":
                VideoService vs = new VideoServiceImpl();
                List<VideoBean> videolist;
                try {
                    videolist = vs.getAll();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("videoList", videolist);
                req.getRequestDispatcher("/page/admin/showvideo.jsp").forward(req, resp);
                break;

            case "comment":
                CommentService cs = new CommentServiceImpl();
                List<CommentBean> commentList;
                try {
                    commentList = cs.getAll();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("commentList", commentList);
                req.getRequestDispatcher("/page/admin/showcomment.jsp").forward(req, resp);
                break;
            case "comment1":
                int uid = Integer.parseInt(req.getParameter("uid"));
                String uname = req.getParameter("uname");
                CommentService cs1 = new CommentServiceImpl();
                UserService usc1 = new UserServiceImpl();
                UserBean ubc1 = new UserBean();
                List<CommentBean> comment1List;
                try {
                    comment1List = cs1.getByUid(uid);
                    ubc1 = usc1.getOne(uname);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("UserOne", ubc1);
                req.setAttribute("commentList", comment1List);
                req.getRequestDispatcher("/page/comment/commentlist.jsp").forward(req, resp);
                break;
            case "comment2":
                // 获取传入的视频ID
                String vidParam = req.getParameter("vid");
                int vid = Integer.parseInt(vidParam);

                // 使用视频ID查询评论
                CommentService commentService = new CommentServiceImpl();
                List<CommentBean> commentList2;
                try {
                    commentList2 = commentService.getByVid(vid);
                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("errorMessage", "查询评论失败");
                    req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
                    return;
                }

                // 设置评论列表到请求属性并跳转
                req.setAttribute("commentList", commentList2);
                req.getRequestDispatcher("/page/teacher/showcomment.jsp").forward(req, resp);
                break;
            case "video1":
                VideoService vs1 = new VideoServiceImpl();
                List<VideoBean> videolist1 = null;
                try {
                    videolist1 = vs1.getAll();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("videoList", videolist1);
                req.getRequestDispatcher("/page/videolist.jsp").forward(req, resp);
                break;
            case "video2":
                // 获取传入的教师姓名
                String teacherName = req.getParameter("tname");
                System.out.println(teacherName);
                if (teacherName == null || teacherName.isEmpty()) {
                    teacherName = "defaultName"; // 默认值
                }

                // 通过教师姓名获取教师ID
                TeacherService teacherService = new TeacherServiceImpl();
                int teacherId = -1;
                try {
                    TeacherBean teacher = teacherService.getOne(teacherName); // 获取教师对象
                    teacherId = teacher.getTid(); // 获取教师ID
                } catch (Exception e) {
                    // 处理没有找到教师的情况
                    e.printStackTrace();
                    req.setAttribute("errorMessage", "教师信息未找到");
                    req.getRequestDispatcher("/page/teacher/error.jsp").forward(req, resp);
                    return;
                }
                // 使用教师ID查询视频
                VideoService vs2 = new VideoServiceImpl();
                List<VideoBean> videolist2 = null;
                try {
                    videolist2 = vs2.getOneByTid(teacherId);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("videoList", videolist2);
                    System.out.println(videolist2);
                System.out.println("!!!!");
                // 设置视频列表到请求属性
                req.setAttribute("videoList", videolist2);

                // 转发到视频管理页面
                req.getRequestDispatcher("/page/teacher/showvideo.jsp").forward(req, resp);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }
}

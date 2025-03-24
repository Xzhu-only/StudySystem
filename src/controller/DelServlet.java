package controller;

import javaBean.CommentBean;
import javaBean.TeacherBean;
import javaBean.UserBean;
import service.Impl.*;
import service.abst.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet("/HandleDel")
public class DelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type=req.getParameter("type");
        switch (type){
            case "user":
                String uname = req.getParameter("uname");
                //System.out.println(uname);
                UserService us=new UserServiceImpl();
                try {
                    //删除用户前先删除评论
                    int uid=us.getOne(uname).getUid();
                    CommentService cs=new CommentServiceImpl();
                    int del_com= cs.deleteByUid(uid);
                    //在删除用户
                    int temp=us.delete(uname);
                    //System.out.println(i);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "admin":
                String aname = req.getParameter("aname");
                //System.out.println(uname);
                AdminService as=new AdminServiceImpl();
                try {
                    int temp=as.delete(aname);
                    //System.out.println(i);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "teacher":
                String tname = req.getParameter("tname");
                TeacherService ts=new TeacherServiceImpl();
                try {//删除教师先删除对应的视频
                    TeacherBean tb=ts.getOne(tname);
                    int tid=tb.getTid();
                    VideoService vs=new VideoServiceImpl();
                    int del_ved=vs.deleteByTid(tid);
                    //再删除教师
                    int temp=ts.delete(tname);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "video":
                String vname = req.getParameter("vname");
                VideoService vs=new VideoServiceImpl();
                try {
                    //删除视频之前先删除对应的评论
                    int vid=vs.getOne(vname).getVid();
                    CommentService cs=new CommentServiceImpl();

                    int del_com=cs.deleteByVid(vid);
                    //再删除视频
                    int temp=vs.delete(vname);
                    //System.out.println(i);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "video1":
                String vname1 = req.getParameter("vname");
                VideoService vs1=new VideoServiceImpl();
                try {
                    //删除视频之前先删除对应的评论
                    int vid=vs1.getOne(vname1).getVid();
                    CommentService cs=new CommentServiceImpl();

                    int del_com=cs.deleteByVid(vid);
                    //再删除视频
                    int temp=vs1.delete(vname1);
                    //System.out.println(i);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/teacher/TeacherFirst.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "comment"://对评论直接删除
                int cid = Integer.parseInt(req.getParameter("cid"));
                CommentService cs=new CommentServiceImpl();
                try {
                    int temp=cs.delete(cid);
                    //System.out.println("评论产出号"+temp);
                    if(temp!=0){//删除成功
                        System.out.println();
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "comment1"://对评论直接删除
                int cid1 = Integer.parseInt(req.getParameter("cid"));
                int uid1 = Integer.parseInt(req.getParameter("uid"));
                String uname1=req.getParameter("uname");
                CommentService cs1=new CommentServiceImpl();
                UserService userService=new UserServiceImpl();
                UserBean ub1;
                List<CommentBean> comment1List;
                try {
                    ub1=userService.getOne(uname1);
                    comment1List = cs1.getByUid(uid1);
                    int temp=cs1.delete(cid1);
                    //System.out.println("评论产出号"+temp);
                    if(temp!=0){//删除成功
                        req.setAttribute("UserOne",ub1);
                        req.setAttribute("commentList", comment1List);
                        req.getRequestDispatcher("/page/comment/commentlist.jsp").forward(req, resp);//返回到用户查看的评论列表
                    }else {
                        resp.sendRedirect("/page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "comment2"://对评论直接删除
                int cid2 = Integer.parseInt(req.getParameter("cid"));
                CommentService cs2=new CommentServiceImpl();
                try {
                    int temp=cs2.delete(cid2);
                    //System.out.println("评论产出号"+temp);
                    if(temp!=0){//删除成功
                        System.out.println();
                        req.getRequestDispatcher("/page/teacher/TeacherFirst.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}

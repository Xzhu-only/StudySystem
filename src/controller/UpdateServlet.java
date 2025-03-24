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

@WebServlet("/HandleUpdate")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type=req.getParameter("type");
        switch (type){
            case "user":
                int Uid = Integer.parseInt(req.getParameter("uid").trim());
                String Uname = req.getParameter("username").trim();
                String major = req.getParameter("major").trim();
                String classname = req.getParameter("classname").trim();
                String Upassword = req.getParameter("password").trim();
                String commits = req.getParameter("commits").trim();
                String safeanwser = req.getParameter("safeanwser").trim();
                String isdelete = req.getParameter("isdelete").trim();
                UserBean ub=new UserBean(Uid,Uname,major,classname,Upassword,commits,safeanwser,isdelete);
                UserService us=new UserServiceImpl();
                try {
                    int temp= us.update(ub);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "teacher":
                String tidParam = req.getParameter("tid");
                String Tname = req.getParameter("username");
                String Tpassword = req.getParameter("password");
                String prone = req.getParameter("prone");
                String introduce1 = req.getParameter("introduce");
                String isdeletes = req.getParameter("isdelete");

                System.out.println("tidParam: " + tidParam);
                System.out.println("Tname: " + Tname);
                System.out.println("Tpassword: " + Tpassword);
                System.out.println("prone: " + prone);
                System.out.println("introduce1: " + introduce1);
                System.out.println("isdeletes: " + isdeletes);

                // 空值检查，避免 null 导致 NullPointerException
                if (tidParam == null || Tname == null || Tpassword == null || prone == null || introduce1 == null || isdeletes == null) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                // 解析 tid 并 trim 字符串
                int Tid = Integer.parseInt(tidParam.trim());
                Tname = Tname.trim();
                Tpassword = Tpassword.trim();
                prone = prone.trim();
                introduce1 = introduce1.trim();
                isdeletes = isdeletes.trim();

                // 创建 TeacherBean 对象
                TeacherBean tb = new TeacherBean(Tid, Tname, Tpassword, prone, introduce1, isdeletes);
                TeacherService ts = new TeacherServiceImpl();

                try {
                    int temp = ts.update(tb);
                    if (temp != 0) {
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

            case "video":
                int Vid = Integer.parseInt(req.getParameter("vid").trim());
                int Tid1 = Integer.parseInt(req.getParameter("tid").trim());
                String Vname = req.getParameter("vname").trim();
                String category = req.getParameter("category").trim();
                String grade = req.getParameter("grade").trim();
                String introduce = req.getParameter("introduce").trim();
                String img = req.getParameter("img").trim();
                String path = req.getParameter("path").trim();
                if (Vname.equals("") || category.equals("")||grade.equals("")){
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                VideoBean vb=new VideoBean(Vid,Tid1,Vname,category,grade,introduce,img,path);
                VideoService vs=new VideoServiceImpl();
                try {
                    int temp= vs.update(vb);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "video1":
              int Vid1 = Integer.parseInt(req.getParameter("vid").trim());
//                int Tid111 = Integer.parseInt(req.getParameter("tid").trim());
                String Vname1 = req.getParameter("vname").trim();
                String category1 = req.getParameter("category").trim();
                String grade1 = req.getParameter("grade").trim();
                String introduce111 = req.getParameter("introduce").trim();
//                String img1 = req.getParameter("img").trim();
//                String path1 = req.getParameter("path").trim();
                if (Vname1.equals("") || category1.equals("")||grade1.equals("")){
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                VideoBean vb1=new VideoBean(Vid1,Vname1,category1,grade1,introduce111);
                VideoService vs1=new VideoServiceImpl();
                try {
                    int temp= vs1.update1(vb1);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/teacher/TeacherFirst.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "admin":
                int Aid = Integer.parseInt(req.getParameter("aid").trim());
                String Aname = req.getParameter("username").trim();
                String Apassword = req.getParameter("password").trim();
                AdminBean ab=new AdminBean(Aid,Aname,Apassword);
                AdminService as=new AdminServiceImpl();
                if (Aname.equals("") || Apassword.equals("")){
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                try {
                    int temp= as.update(ab);
                    if(temp!=0){
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "userp":
                String name = req.getParameter("uname").trim();
                String password = req.getParameter("password").trim();
                if (name.equals("") || password.equals("")){
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
               UserService us1=new UserServiceImpl();
                try {
                    int temp= us1.modifyPass(name,password);
                    if(temp!=0){
                        resp.sendRedirect("page/login.jsp?ModifyError=success");
                    }else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "usermod":
                int Uidm = Integer.parseInt(req.getParameter("uid").trim());
                String Unamem = req.getParameter("username").trim();
                String Majorm = req.getParameter("major").trim();
                String Classnamem = req.getParameter("classname").trim();
                String Upasswordm = req.getParameter("password").trim();
                String commitsm = req.getParameter("commits").trim();
                String safeanwserm = req.getParameter("safeanwser").trim();
                String isdeletem = "no";

                if (Unamem.equals("") || Upasswordm.equals("")||safeanwserm.equals("")){
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                UserBean ubm=new UserBean(Uidm,Unamem,Majorm,Classnamem,Upasswordm,commitsm,safeanwserm,isdeletem);
                UserBean ub2;
                UserService usm=new UserServiceImpl();
                try {
                    int temp= usm.update(ubm);
                    if(temp!=0){
                        ub2=usm.getOne(Unamem);
                        req.setAttribute("userOne",ub2);
                        req.getRequestDispatcher("/page/userinfo.jsp").forward(req, resp);
                    }else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "teachermod":
                String tidParam1 = req.getParameter("tid");
                String Tname1 = req.getParameter("tname");
                String Tpassword1 = req.getParameter("password");
                String prone1 = req.getParameter("prone");
                String introduce11 = req.getParameter("introduce");
System.out.println("******");
                System.out.println("tidParam: " + tidParam1);
                System.out.println("Tname: " + Tname1);
                System.out.println("Tpassword: " + Tpassword1);
                System.out.println("prone: " + prone1);
                System.out.println("introduce1: " + introduce11);

                // 空值检查，避免 null 导致 NullPointerException
                if (tidParam1 == null || Tname1 == null || Tpassword1 == null || prone1 == null || introduce11 == null ) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                // 解析 tid 并 trim 字符串
                int Tid11 = Integer.parseInt(tidParam1.trim());
                Tname = Tname1.trim();
                Tpassword = Tpassword1.trim();
                prone = prone1.trim();
                introduce1 = introduce11.trim();

                // 创建 TeacherBean 对象
                TeacherBean tb1 = new TeacherBean(Tid11, Tname, Tpassword, prone, introduce1);
                TeacherService ts1 = new TeacherServiceImpl();

                try {
                    int temp = ts1.update(tb1);
                    if (temp != 0) {
                        req.getRequestDispatcher("/page/teacher/teacherinfo.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

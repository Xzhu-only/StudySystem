package controller;

import javaBean.CommentBean;
import javaBean.UserBean;
import javaBean.VideoBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.*;
import service.abst.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/HandleAdd")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        switch (type) {
            case "user":
                String Uname = req.getParameter("username").trim();
                String Major = req.getParameter("major").trim();
                String Claname = req.getParameter("claname").trim();
                String Upassword = req.getParameter("password").trim();
                String commits = req.getParameter("commits").trim();
                String safeanwser = req.getParameter("safeanwser").trim();
                if (Uname.equals("") || Upassword.equals("") || safeanwser.equals("")) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                boolean boo = Uname.length() > 0 && Upassword.length() > 0;
                if (!boo) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                UserService us = new UserServiceImpl();
                try {
                    boolean temp = us.register(Uname, Upassword, Major, Claname, commits, safeanwser);//获取查询结果
                    if (temp) {//插入成功
                        req.getRequestDispatcher("/page/admin/manager.jsp").forward(req, resp);
                    } else {//插入失败
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "teacher":
                String Tname = req.getParameter("username").trim();
                String Tpassword = req.getParameter("password").trim();
                String prone = req.getParameter("prone").trim();
                String introduce = req.getParameter("introduce").trim();

                if (Tname.equals("") || Tpassword.equals("") || prone.equals("")) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                boolean boo1 = Tname.length() > 0 && Tpassword.length() > 0;
                if (!boo1) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                TeacherService ts = new TeacherServiceImpl();
                try {
                    boolean temp = ts.register(Tname, Tpassword, prone, introduce);//获取查询结果
                    if (temp) {//插入成功
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    } else {//插入失败
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case "admin":
                String Aname = req.getParameter("username").trim();
                String Apassword = req.getParameter("password").trim();
                if (Aname.equals("") || Apassword.equals("")) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                boolean boo2 = Aname.length() > 0 && Apassword.length() > 0;
                if (!boo2) {
                    resp.sendRedirect("page/error.jsp");
                    return;
                }
                AdminService as = new AdminServiceImpl();
                try {
                    boolean temp = as.add(Aname, Apassword);//获取查询结果
                    if (temp) {//插入成功
                        req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp);
                    } else {//插入失败
                        resp.sendRedirect("page/error.jsp");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "videos":
                String tid = null;
                String vname = null;
                String category = null;
                String grade = null;
                String introduce1 = null;
                String img = null;
                String videopath = null;
                boolean isMultipart = ServletFileUpload.isMultipartContent(req);
                if (isMultipart) { // 判断是否为多段数据
                    DiskFileItemFactory factory = new DiskFileItemFactory(); // 创建工厂实现类
                    String basePath = req.getServletContext().getRealPath("/"); // 获取 Tomcat Web 应用的根路径
                    String imgPath = basePath + "page/static/images/"; // 图片保存路径
                    String videoPath = basePath + "page/static/videos/"; // 视频保存路径

                    // 打印图片路径
                    System.out.println("图片保存路径：" + imgPath);

                    // 设置临时文件存放路径
                    factory.setRepository(new File(basePath));
                    factory.setSizeThreshold(10240); // 设置缓冲区大小
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    upload.setSizeMax(61440000); // 设置单个文件最大值

                    // 确保图片目录存在
                    File imgDir = new File(imgPath);
                    if (!imgDir.exists()) {
                        imgDir.mkdirs(); // 如果目录不存在，则创建目录
                    }

                    // 确保视频目录存在
                    File videoDir = new File(videoPath);
                    if (!videoDir.exists()) {
                        videoDir.mkdirs(); // 如果目录不存在，则创建目录
                    }

                    try {
                        List<FileItem> list = upload.parseRequest(req); // 解析请求
                        for (FileItem fileItem : list) {
                            if (fileItem.isFormField()) {
                                String filedName = fileItem.getFieldName();
                                if (filedName.equals("vname")) {
                                    vname = fileItem.getString("UTF-8");
                                } else if (filedName.equals("grade")) {
                                    grade = fileItem.getString("UTF-8");
                                } else if (filedName.equals("category")) {
                                    category = fileItem.getString("UTF-8");
                                } else if (filedName.equals("introduce")) {
                                    introduce1 = fileItem.getString("UTF-8");
                                } else if (filedName.equals("tid")) {
                                    tid = fileItem.getString("UTF-8");
                                }
                            } else { // 文件表单项
                                if (fileItem.getFieldName().equals("img")) { // 图片上传
                                    String imgType = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                                    String imgName = UUID.randomUUID() + imgType; // 生成唯一的文件名
                                    File imgFile = new File(imgPath, imgName); // 创建文件对象
                                    System.out.println("图片文件保存路径：" + imgFile.getAbsolutePath()); // 打印图片文件路径
                                    try {
                                        fileItem.write(imgFile); // 保存图片文件
                                        img = "/page/static/images/" + imgName; // 保存相对路径到数据库
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "图片文件保存失败：" + e.getMessage());
                                        return; // 停止后续操作
                                    }
                                }

                                if (fileItem.getFieldName().equals("videopath")) { // 视频上传
                                    String videoType = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                                    String videoName = UUID.randomUUID() + videoType; // 生成唯一的文件名
                                    File videoFile = new File(videoPath, videoName); // 创建文件对象
                                    System.out.println("视频文件保存路径：" + videoFile.getAbsolutePath()); // 打印视频文件路径

                                    try (InputStream fileContent = fileItem.getInputStream()) {
                                        Files.copy(fileContent, videoFile.toPath()); // 保存视频文件
                                        videopath = "/page/static/videos/" + videoName; // 保存相对路径到数据库
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "视频文件保存失败：" + e.getMessage());
                                        return; // 停止后续操作
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "文件上传失败");
                        return; // 停止后续操作
                    }

                    // 校验上传的 videopath 是否有效
                    if (videopath == null || videopath.isEmpty()) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "视频路径不能为空");
                        return; // 停止后续操作
                    }

                    // 校验其他参数是否有效
                    if (vname == null || vname.isEmpty() || grade == null || grade.isEmpty() || category == null || category.isEmpty() || tid == null || tid.isEmpty()) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "所有字段不能为空");
                        return; // 停止后续操作
                    }

                    // 调用 VideoService 保存信息
                    VideoService vs = new VideoServiceImpl();
                    boolean vtemp = vs.add(Integer.parseInt(tid), vname, category, grade, introduce1, img, videopath);
                    if (vtemp) {
                        try {
                            req.getRequestDispatcher("/page/admin/manage.jsp").forward(req, resp); // 成功后跳转
                        } catch (Exception e) {
                            e.printStackTrace();
                            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "跳转失败");
                        }
                    } else {
                        resp.sendRedirect("page/error.jsp"); // 失败后跳转
                    }
                    break;
                }
            case "videos1":
                String tid1 = null;
                String vname1 = null;
                String category1 = null;
                String grade1 = null;
                String introduce111 = null;
                String img1 = null;
                String videopath1 = null;
                boolean isMultipart1 = ServletFileUpload.isMultipartContent(req);
                if (isMultipart1) { // 判断是否为多段数据
                    DiskFileItemFactory factory = new DiskFileItemFactory(); // 创建工厂实现类
                    String basePath = req.getServletContext().getRealPath("/"); // 获取 Tomcat Web 应用的根路径
                    String imgPath = basePath + "page/static/images/"; // 图片保存路径
                    String videoPath = basePath + "page/static/videos/"; // 视频保存路径

                    // 打印图片路径
                    System.out.println("图片保存路径：" + imgPath);

                    // 设置临时文件存放路径
                    factory.setRepository(new File(basePath));
                    factory.setSizeThreshold(10240); // 设置缓冲区大小
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    upload.setSizeMax(61440000); // 设置单个文件最大值

                    // 确保图片目录存在
                    File imgDir = new File(imgPath);
                    if (!imgDir.exists()) {
                        imgDir.mkdirs(); // 如果目录不存在，则创建目录
                    }

                    // 确保视频目录存在
                    File videoDir = new File(videoPath);
                    if (!videoDir.exists()) {
                        videoDir.mkdirs(); // 如果目录不存在，则创建目录
                    }

                    try {
                        List<FileItem> list = upload.parseRequest(req); // 解析请求
                        for (FileItem fileItem : list) {
                            if (fileItem.isFormField()) {
                                String filedName = fileItem.getFieldName();
                                if (filedName.equals("vname")) {
                                    vname1 = fileItem.getString("UTF-8");
                                } else if (filedName.equals("grade")) {
                                    grade1 = fileItem.getString("UTF-8");
                                } else if (filedName.equals("category")) {
                                    category1 = fileItem.getString("UTF-8");
                                } else if (filedName.equals("introduce")) {
                                    introduce111 = fileItem.getString("UTF-8");
                                } else if (filedName.equals("tid")) {
                                    tid1 = fileItem.getString("UTF-8");
                                }
                            } else { // 文件表单项
                                if (fileItem.getFieldName().equals("img")) { // 图片上传
                                    String imgType = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                                    String imgName = UUID.randomUUID() + imgType; // 生成唯一的文件名
                                    File imgFile = new File(imgPath, imgName); // 创建文件对象
                                    System.out.println("图片文件保存路径：" + imgFile.getAbsolutePath()); // 打印图片文件路径
                                    try {
                                        fileItem.write(imgFile); // 保存图片文件
                                        img1 = "/page/static/images/" + imgName; // 保存相对路径到数据库
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "图片文件保存失败：" + e.getMessage());
                                        return; // 停止后续操作
                                    }
                                }

                                if (fileItem.getFieldName().equals("videopath")) { // 视频上传
                                    String videoType = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                                    String videoName = UUID.randomUUID() + videoType; // 生成唯一的文件名
                                    File videoFile = new File(videoPath, videoName); // 创建文件对象
                                    System.out.println("视频文件保存路径：" + videoFile.getAbsolutePath()); // 打印视频文件路径

                                    try (InputStream fileContent = fileItem.getInputStream()) {
                                        Files.copy(fileContent, videoFile.toPath()); // 保存视频文件
                                        videopath1 = "/page/static/videos/" + videoName; // 保存相对路径到数据库
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "视频文件保存失败：" + e.getMessage());
                                        return; // 停止后续操作
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "文件上传失败");
                        return; // 停止后续操作
                    }

                    // 校验上传的 videopath 是否有效
                    if (videopath1 == null || videopath1.isEmpty()) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "视频路径不能为空");
                        return; // 停止后续操作
                    }

                    // 校验其他参数是否有效
                    if (vname1 == null || vname1.isEmpty() || grade1 == null || grade1.isEmpty() || category1 == null || category1.isEmpty() || tid1 == null || tid1.isEmpty()) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "所有字段不能为空");
                        return; // 停止后续操作
                    }

                    // 调用 VideoService 保存信息
                    VideoService vs = new VideoServiceImpl();
                    boolean vtemp = vs.add(Integer.parseInt(tid1), vname1, category1, grade1, introduce111, img1, videopath1);
                    if (vtemp) {
                        try {
                            req.getRequestDispatcher("/page/teacher/TeacherFirst.jsp").forward(req, resp); // 成功后跳转
                        } catch (Exception e) {
                            e.printStackTrace();
                            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "跳转失败");
                        }
                    } else {
                        resp.sendRedirect("page/error.jsp"); // 失败后跳转
                    }
                    break;
                }

            case "comment1":
                        String uname = req.getParameter("uname").trim();
                        int vid = Integer.parseInt(req.getParameter("vid"));
                        String commentText = req.getParameter("comments").trim();
                        if (commentText.equals("")) {
                            resp.sendRedirect("page/error.jsp");
                            return;
                        }
                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = dateFormat.format(currentDate);  // 格式化为 yyyy-MM-dd


                        boolean boo3 = commentText.length() > 0;
                        if (boo3) {
                            UserService usc = new UserServiceImpl();
                            VideoService vsc = new VideoServiceImpl();
                            CommentService cs = new CommentServiceImpl();
                            List<CommentBean> comment1List;
                            try {
                                UserBean one = usc.getOne(uname);
                                VideoBean vb;
                                boolean temp = cs.add(one.getUid(), vid, formattedDate, commentText);
                                CommentBean cb = new CommentBean();
                                cb.setUid(one.getUid());
                                cb.setCreate_time(formattedDate);
                                cb.setComment(commentText);
                                vb = vsc.getOneByVid(vid);
                                comment1List = cs.getByVid(vid);
                                if (temp) {//插入成功
                                    req.setAttribute("videoOne", vb);
                                    req.setAttribute("commentslist", comment1List);
                                    req.getRequestDispatcher("/page/play.jsp").forward(req, resp);
                                } else {//插入失败
                                    resp.sendRedirect("page/error.jsp");
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        break;
                }
        }
    }

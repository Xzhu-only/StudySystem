package controller;

import javaBean.CommentBean;
import javaBean.VideoBean;
import service.Impl.CommentServiceImpl;
import service.Impl.UserServiceImpl;
import service.Impl.VideoServiceImpl;
import service.abst.CommentService;
import service.abst.UserService;
import service.abst.VideoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HandlePlay")
public class PlayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int vid = Integer.parseInt(req.getParameter("vid"));
        VideoService vs=new VideoServiceImpl();
        CommentService cs=new CommentServiceImpl();
        List<CommentBean> comment1List;
        VideoBean vb= null;//获取查询结果
        //拿到id后查询这条数据，转到修改页，修改后发送修改请求
        try {
            vb = vs.getOneByVid(vid);
            comment1List=cs.getByVid(vid);
            req.setAttribute("videoOne", vb);
            req.setAttribute("commentslist", comment1List);
            req.getRequestDispatcher("/page/play.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}

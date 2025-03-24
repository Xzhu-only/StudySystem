package controller;

import javaBean.VideoBean;
import service.Impl.VideoServiceImpl;
import service.abst.VideoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HandleSearch")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String keyword = req.getParameter("keyword");
        String instrumentType = req.getParameter("instrumentType");
        String hardType = req.getParameter("hardType");
        String type = req.getParameter("type");
        System.out.println("instrumentType: " + instrumentType);
        System.out.println("hardType: " + hardType);
        System.out.println("type: " + type);

        System.out.println("All request parameters: " + req.getParameterMap());

        switch (type) {
            case "search":
                VideoService vs = new VideoServiceImpl();
                List<VideoBean> videolist;
                try {
                    videolist = vs.getByKeyword(keyword);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("videoList", videolist);
                req.getRequestDispatcher("/page/videolist.jsp").forward(req, resp);
                break;
            case "category":
                VideoService vs1 = new VideoServiceImpl();
                List<VideoBean> videolist1;
                try {
                    videolist1 = vs1.getByCategory(instrumentType,hardType);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("videoList", videolist1);
                req.getRequestDispatcher("/page/videolist.jsp").forward(req, resp);
                break;
        }


    }
}

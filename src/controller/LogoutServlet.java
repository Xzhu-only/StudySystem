package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/HandleLogout")
public class LogoutServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 获取当前的 Session，如果没有则不会创建新的 Session
            HttpSession session = request.getSession(false);
            if (session != null) {
                // 从 Session 中移除用户名信息
                session.removeAttribute("uname");
                // 注销 Session
                session.invalidate();
            }
            // 重定向到登录页面或其他需要的页面
            response.sendRedirect("index.jsp"); //
        }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}

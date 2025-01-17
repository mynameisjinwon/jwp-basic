package next.web;

import java.io.IOException;


import core.db.DataBase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import next.model.User;

@WebServlet("/user/list")
public class ListUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자 목록 조회는 로그인한 사용자만 볼 수 있다.
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        // 로그인한 상태가 아니면
        if (value == null) {
            resp.sendRedirect("/user/login");
            return;
        }

        User user = (User) value;

        req.setAttribute("loginUser", user);
        req.setAttribute("users", DataBase.findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
        rd.forward(req, resp);
    }
}

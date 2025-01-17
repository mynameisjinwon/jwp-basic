package next.web;

import core.db.DataBase;
import next.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        User user = DataBase.findUserById(userId);

        request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("/user/update.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = String.valueOf(request.getAttribute("userId"));
        String password = String.valueOf(request.getAttribute("password"));
        String name = String.valueOf(request.getAttribute("name"));
        String email = String.valueOf(request.getAttribute("email"));

        User user = DataBase.findUserById(userId);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);

        DataBase.addUser(user);
        response.sendRedirect("/user/list");
    }
}

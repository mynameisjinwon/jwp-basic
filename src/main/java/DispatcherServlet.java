import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("DispatcherServlet.doGet() 호출 됨!");
        PrintWriter out = response.getWriter();
        out.print("<h1>hello world</h1>");
    }
}

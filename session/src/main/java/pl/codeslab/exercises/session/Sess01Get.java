package pl.codeslab.exercises.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/Sess01Get") public class Sess01Get extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("counter") != null) {
            int counter = (int) session.getAttribute("counter");
            resp.getWriter().println(counter);
            ++counter;
            session.setAttribute("counter", counter);
        } else {
            resp.getWriter().println("brak zmiennej counter");
        }
    }

}

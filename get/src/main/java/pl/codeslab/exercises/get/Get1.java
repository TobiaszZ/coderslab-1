package pl.codeslab.exercises.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Get1") public class Get1 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        if ((start != null) && !start.isEmpty() && (end != null) && !end.isEmpty()) {
            int startInt = Integer.parseInt(start);
            int endInt = Integer.parseInt(end);
            for (int i = startInt; i <= endInt; ++i) {
                resp.getWriter().println(i);
            }
        } else {
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html");
            resp.getWriter().println("Brak przesłanych parametrów");
        }
    }
}

package pl.codeslab.exercises.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Sess01Get") public class Sess01Get extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer counter = (Integer) request.getSession().getAttribute("counter");
        PrintWriter writer = response.getWriter();
        if (counter != null) {
            request.getSession().setAttribute("counter", counter + 1);
            writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Counter: " + counter + "</p></body></html>");
        } else {
            writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Counter: brak</p></body></html>");
        }
    }

}

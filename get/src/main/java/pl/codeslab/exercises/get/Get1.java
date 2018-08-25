package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Get1") public class Get1 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        if ((start != null) && !start.isEmpty() && (end != null) && !end.isEmpty()) {
            writer.append("<ul>");
            for (long i = Long.valueOf(start); i <= Long.valueOf(end); ++i) {
                writer.append("<li>" + i + "</li>");
            }
            writer.append("</ul>");
        } else {
            writer.append("Brak przesłanych zmiennych");
        }
        writer.append("</body></html>");
    }

}

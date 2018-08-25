package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Get4") public class Get4 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long page = Long.valueOf(request.getParameter("page"));
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Wartość " + page + " została przesłana.</p><ul>");
        for (long i = 1; i <= page; ++i) {
            if ((page % i) == 0) {
                writer.append("<li>" + i + "</li>");
            }
        }
        writer.append("</ul></body></html>");
    }

}

package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Get3") public class Get3 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long width = parseLongParameter(request, "width", 5);
        long height = parseLongParameter(request, "height", 10);
        PrintWriter writer = response.getWriter();
        writer.append("<html><body>");
        writer.append("<table>");
        for (long i = 1; i <= height; ++i) {
            writer.append("<tr>");
            for (long j = 1; j <= width; ++j) {
                writer.append("<td>" + (i * j) + "</td>");
            }
            writer.append("</tr>");
        }
        writer.append("</table>");
        writer.append("</body></html>");
    }

    private long parseLongParameter(HttpServletRequest request, String name, long valueDefault) {
        String parameter = request.getParameter(name);
        if ((parameter != null) && !parameter.isEmpty()) {
            try {
                return Long.valueOf(parameter);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return valueDefault;
    }

}

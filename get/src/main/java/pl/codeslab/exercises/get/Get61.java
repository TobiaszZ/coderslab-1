package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Get61") public class Get61 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.append("<html><body>");
        writer.append("<ul>");
        for (int i = 1980; i <= 2010; ++i) {
            writer.append("<li><a href=\"Get62?year=" + i + "\"> Link do roku " + i + " </a></li>");
        }
        writer.append("</ul>");
        writer.append("</body></html>");
    }

}

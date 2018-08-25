package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(value = "/Get62") public class Get62 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.append("<html><body>");
        writer.append("<ul>");
        Random random = new Random();
        for (int i = 0; i < 5; ++i) {
            String year = request.getParameter("year");
            int mix = random.nextInt(21) - 10;
            writer.append("<li><a href=\"Get63?year=" + year + "&mix=" + mix + "\"> Rok " + year + ", mix " + mix + " </a></li>");
        }
        writer.append("</ul>");
        writer.append("</body></html>");
    }

}

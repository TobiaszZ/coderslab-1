package pl.codeslab.exercises.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/showAllSession") public class Sess03_All extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<String> keys = (List<String>) session.getAttribute("keys");
        if (keys == null) {
            keys = new LinkedList<>();
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<table>");
        for (String key : keys) {
            writer.append("<tr><td>" + key + "</td><td>" + session.getAttribute(key) + "</td></tr>");
        }
        writer.append("</table>");
        writer.append("</body></html>");
    }

}

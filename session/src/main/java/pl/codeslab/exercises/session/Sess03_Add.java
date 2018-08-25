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

@WebServlet(value = "/addToSession") public class Sess03_Add extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<form method=\"post\"><label>Klucz: <input type=\"text\" name=\"key\"></label>"
                + "<label>Wartość: <input type=\"text\" name=\"value\"></label>" + "<input type=\"submit\"></form>");
        writer.append("</body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<String> keys = (List<String>) session.getAttribute("keys");
        if (keys == null) {
            keys = new LinkedList<>();
        }
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        keys.add(key);
        session.setAttribute("keys", keys);
        session.setAttribute(key, value);
        response.sendRedirect("showAllSession");
    }

}

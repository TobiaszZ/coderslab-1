package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Cookie4Show") public class Cookie4Show extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><ul>");
        for (Cookie cookie : request.getCookies()) {
            writer.append("<li>" + cookie.getName() + " = " + cookie.getValue() + " <a href=\"Cookie4Del?name=" + cookie.getName() + "\">usuń</a>" + "</li>");
        }
        writer.append("</ul></body></html>");
    }

}

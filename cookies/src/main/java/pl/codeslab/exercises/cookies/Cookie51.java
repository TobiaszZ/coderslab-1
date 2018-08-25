package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/Cookie51") public class Cookie51 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("Cookie51Visited", "true");
        response.addCookie(cookie);
        String error = request.getParameter("error");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>");
        if (Objects.equals(error, "true")) {
            writer.append("Nie odwiedziłeś jeszcze tej strony<br/>");
        }
        writer.append("<a href=\"Cookie52\">Cookie52</a>");
        writer.append("</p></body></html>");
    }

}

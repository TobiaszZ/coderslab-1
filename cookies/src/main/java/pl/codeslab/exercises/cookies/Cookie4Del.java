package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/Cookie4Del") public class Cookie4Del extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        Cookie cookie = getCookie(request, request.getParameter("name"));
        PrintWriter writer = response.getWriter();
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Usunięto ciasteczko " + cookie.getName() + "</p></body></html>");
    }

    private Cookie getCookie(HttpServletRequest request, String name) {
        for (Cookie cookie : request.getCookies()) {
            if (Objects.equals(cookie.getName(), name)) {
                return cookie;
            }
        }
        return null;
    }

}

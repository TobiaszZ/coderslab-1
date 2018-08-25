package pl.codeslab.exercises.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/showCookie") public class Cookie1Get extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookieFound = null;
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (Objects.equals(cookie.getName(), "User")) {
                    cookieFound = cookie;
                }
            }
        }
        if (cookieFound != null) {
            resp.getWriter().println(cookieFound.getName() + " = " + cookieFound.getValue());
        } else {
            resp.getWriter().println("Brak ciasteczka");
        }
    }
}

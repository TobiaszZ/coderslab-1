package pl.codeslab.exercises.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/deleteCookie") public class Cookie1Del extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookieFound = null;
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (Objects.equals(cookie.getName(), "User")) {
                    cookieFound = cookie;
                    cookieFound.setMaxAge(0);
                    resp.addCookie(cookieFound);
                }
            }
        }
    }
}

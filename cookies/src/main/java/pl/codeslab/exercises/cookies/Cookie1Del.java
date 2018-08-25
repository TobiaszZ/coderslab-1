package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/deleteCookie") public class Cookie1Del extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = getCookie(request, "User");
        PrintWriter writer = response.getWriter();
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>" + ((cookie != null) ? "" : "nie ma takiego ciasteczka") + "</p></body></html>");
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

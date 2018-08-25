package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/Cookie52") public class Cookie52 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = getCookie(request, "Cookie51Visited");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        if ((cookie != null) && Objects.equals(cookie.getValue(), "true")) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Witamy na stronie Cookie52</p></body></html>");
        } else {
            response.sendRedirect("Cookie51?error=true");
        }
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

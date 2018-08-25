package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/rememberMe") public class Cookie7 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = getCookie(request, "name");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        if (cookie != null) {
            writer.append("Cześć " + cookie.getValue() + ". Twoje dane zostały wczytane z ciasteczka");
        } else {
            writer.append(
                    "<form method=\"post\"><input type=\"text\" name=\"name\"/><input type=\"checkbox\" name=\"rememberMe\" value=\"true\"/>Zapamiętaj mnie<input type=\"submit\"/></form>");
        }
        writer.append("</body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String rememberMe = request.getParameter("rememberMe");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("Cześć " + name);
        writer.append("</body></html>");
        if (Objects.equals(rememberMe, "true")) {
            Cookie cookie = new Cookie("name", name);
            response.addCookie(cookie);
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

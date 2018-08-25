package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/Cookie6") public class Cookie6 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookieText = getCookie(request, "text");
        Cookie cookieBackground = getCookie(request, "background");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        if ((cookieText != null) && (cookieBackground != null)) {
            writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Zapamiętany w ciasteczku kolor tekstu to: " + cookieText.getValue()
                    + ", oraz tła jako: " + cookieBackground.getValue() + ".</p></body></html>");
        } else {
            response.sendRedirect("index_6.html");
        }
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("text");
        String background = request.getParameter("background");

        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Wybrałeś kolor tekstu jako: " + text + ", oraz tła jako: " + background
                + ". Twój wybór został zapisane w ciasteczku.</p></body></html>");
        Cookie cookieText = new Cookie("text", text);
        Cookie cookieBackground = new Cookie("background", background);
        response.addCookie(cookieText);
        response.addCookie(cookieBackground);
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

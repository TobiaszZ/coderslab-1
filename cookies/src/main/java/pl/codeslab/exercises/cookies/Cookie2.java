package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addToCookie") public class Cookie2 extends HttpServlet {

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        Cookie cookie = new Cookie(key, value);
        response.addCookie(cookie);
    }

}

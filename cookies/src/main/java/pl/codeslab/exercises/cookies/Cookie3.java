package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/Cookie3") public class Cookie3 extends HttpServlet {

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        int maxAge = Integer.valueOf(request.getParameter("max_age"));
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * maxAge);
        response.addCookie(cookie);
    }

}

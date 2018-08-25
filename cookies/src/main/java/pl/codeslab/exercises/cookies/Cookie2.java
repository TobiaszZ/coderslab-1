package pl.codeslab.exercises.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/addToCookie") public class Cookie2 extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String cookieName = req.getParameter("key");
        String cookieValue = req.getParameter("value");
        Cookie cookie = new Cookie(cookieName, cookieValue);
        resp.addCookie(cookie);
    }
}

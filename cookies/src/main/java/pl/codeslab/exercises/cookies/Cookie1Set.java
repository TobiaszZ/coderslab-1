package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/setCookie") public class Cookie1Set extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("User", "Coders Lab");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

}

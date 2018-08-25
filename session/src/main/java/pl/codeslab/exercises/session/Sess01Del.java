package pl.codeslab.exercises.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/Sess01Del") public class Sess01Del extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("counter");
    }

}

package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Get63") public class Get63 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int year = Integer.valueOf(request.getParameter("year"));
        int mix = Integer.valueOf(request.getParameter("mix"));
        int result = year + mix;
        response.getWriter().append("<html><body><p>Rok to: " + result + "</p></body></html>");
    }

}

package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Post1") public class Post1 extends HttpServlet {

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Witaj, " + firstName + " " + lastName + "</p></body></html>");
    }

}

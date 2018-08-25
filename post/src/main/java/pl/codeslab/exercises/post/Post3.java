package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Post3") public class Post3 extends HttpServlet {

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double a = Double.valueOf(request.getParameter("a"));
        double b = Double.valueOf(request.getParameter("b"));
        double c = Double.valueOf(request.getParameter("c"));
        double delta = b * b - 4 * a * c;
        String result;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            result = "x1 = " + x1 + ", x2 = " + x2;
        } else if (delta == 0) {
            double x = (-b) / (2 * a);
            result = "x = " + x;
        } else {
            result = "brak miejsc zerowych";
        }
        response.getWriter().append("<html><head><meta charset=\"UTF-8\"></head><body><p>" + result + "</p></body></html>");
    }

}

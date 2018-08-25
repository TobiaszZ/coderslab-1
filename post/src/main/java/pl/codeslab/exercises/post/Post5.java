package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(value = "/Post5") public class Post5 extends HttpServlet {

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double degrees = Double.valueOf(request.getParameter("degrees"));
        String convertionType = request.getParameter("convertionType");
        Double result = null;
        String resultType = null;
        if (Objects.equals(convertionType, "celcToFahr")) {
            result = 32.0 + 9.0 * degrees / 5.0;
            resultType = "F";
        } else if (Objects.equals(convertionType, "FahrToCelc")) {
            result = 5.0 * (degrees - 32.0) / 9.0;
            resultType = "C";
        }
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>Wynik: " + result + " " + resultType + "</p></body></html>");
    }

}

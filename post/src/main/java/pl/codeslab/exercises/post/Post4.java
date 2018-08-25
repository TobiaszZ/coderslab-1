package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@WebServlet(value = "/Post4") public class Post4 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        Random random = new Random();
        int count = random.nextInt(6) + 5;
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><form method=\"post\">");
        for (int i = 0; i < count; ++i) {
            writer.append("<input name=\"numbers\"/><br/>");
        }
        writer.append("<input type=\"submit\"/>");
        writer.append("</form></body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Long> numbers = new LinkedList<>();
        for (String parameter : request.getParameterValues("numbers")) {
            Long parameterValue = parseLong(parameter);
            if (parameterValue != null) {
                numbers.add(parameterValue);
            }
        }
        numbers.sort(null);
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><ul>");
        for (long number : numbers) {
            writer.append("<li>" + number + "</li>");
        }
        writer.append("</ul></body></html>");
    }

    private Long parseLong(String value) {
        if ((value != null) && !value.isEmpty()) {
            try {
                return Long.valueOf(value);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

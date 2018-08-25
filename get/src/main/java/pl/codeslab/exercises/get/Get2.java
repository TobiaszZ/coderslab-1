package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

@WebServlet(value = "/Get2") public class Get2 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<ul>");
        request.getParameterMap().entrySet()
                .forEach(parameter -> writer.append("<li>" + parameter.getKey() + " = " + formatValues(parameter.getValue()) + "</li>"));
        writer.append("</ul>");
        writer.append("</body></html>");
    }

    private String formatValues(String[] values) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String value : values) {
            stringJoiner.add(value);
        }
        return stringJoiner.toString();
    }

}

package pl.codeslab.exercises.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/Get5") public class Get5 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.append("<html><body>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            writer.append("<p>" + parameterName + ":</p>");
            writer.append("<ul>");
            for (String parameterValue : request.getParameterValues(parameterName)) {
                writer.append("<li>" + parameterValue + "</li>");
            }
            writer.append("</ul>");
        }
        writer.append("</body></html>");
    }

}

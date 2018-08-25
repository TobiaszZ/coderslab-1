package pl.codeslab.exercises.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;

@WebServlet(value = "/Get2") public class Get2 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> parameter : parameterMap.entrySet()) {
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (String value : parameter.getValue()) {
                stringJoiner.add(value);
            }
            resp.getWriter().println(parameter.getKey() + " = " + stringJoiner.toString());
        }
    }
}

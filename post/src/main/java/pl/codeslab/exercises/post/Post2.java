package pl.codeslab.exercises.post;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebServlet(value = "/Post2") public class Post2 extends HttpServlet {

    private static final List<String> BLACK_LIST = Arrays.asList("cholera", "do diaska");

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("text");
        String filter = request.getParameter("filter");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        if (!Objects.equals(filter, "false")) {
            for (String filteredWord : BLACK_LIST) {
                StringBuilder replacement = new StringBuilder();
                for (int i = 0; i < filteredWord.length(); ++i) {
                    replacement.append("*");
                }
                text = text.replaceAll(filteredWord, replacement.toString());
            }
        }
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>" + text + "</p></body></html>");
    }

}

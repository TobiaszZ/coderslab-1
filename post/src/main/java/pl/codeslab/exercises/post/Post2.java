package pl.codeslab.exercises.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebServlet(value = "/Post2") public class Post2 extends HttpServlet {

    private static final List<String> WULGARYZMY = Arrays.asList("cholera", "kurde", "motyla noga");

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String cyrograf = req.getParameter("cyrograf");
        if (!Objects.equals(cyrograf, "1")) {
            for (String word : WULGARYZMY) {
                StringBuilder replacement = new StringBuilder();
                for (int i = 0; i < word.length(); ++i) {
                    replacement.append("*");
                }
                text = text.replaceAll(word, replacement.toString());
            }
        }
        resp.getWriter().println(text);
    }
}

package pl.codeslab.exercises.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Sess02") public class Sess02 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer[] scores = (Integer[]) request.getSession().getAttribute("scores");
        if (scores == null) {
            scores = new Integer[0];
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<form method=\"post\"><input name=\"score\"/><input type=\"submit\"/></form>");
        writer.append("<ul>");
        long sum = 0;
        for (int score : scores) {
            writer.append("<li>" + score + "</li>");
            sum += score;
        }
        writer.append("</ul>");
        if (scores.length > 0) {
            writer.append("<p>Średnia: " + ((double) sum / scores.length) + "</p>");
        }
        writer.append("</body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int score = Integer.valueOf(request.getParameter("score"));
        if ((score >= 1) && (score <= 6)) {
            Integer[] scores = (Integer[]) request.getSession().getAttribute("scores");
            if (scores == null) {
                scores = new Integer[0];
            }
            Integer[] scoresNew = new Integer[scores.length + 1];
            for (int i = 0; i < scores.length; ++i) {
                scoresNew[i] = scores[i];
            }
            scoresNew[scores.length] = score;
            request.getSession().setAttribute("scores", scoresNew);
            response.sendRedirect("Sess02");
        } else {
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.append("<html><head><meta charset=\"UTF-8\"></head><body>Niepoprawna ocena</body></html>");
        }
    }
}

package pl.codeslab.exercises.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/Sess02") public class Sess02 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Integer> scores = new LinkedList<>();
        if (session.getAttribute("scores") != null) {
            scores = (List<Integer>) session.getAttribute("scores");
        }
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        resp.getWriter().println(
                "<html><body><form action=\"Sess02\" method=\"post\">\n" + "    <input type=\"text\" name=\"score\"/>\n" + "    <input type=\"submit\"/>\n"
                        + "</form></body></html>");
        resp.getWriter().println("Średnia: " + ((double) sum / scores.size()));
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String score = req.getParameter("score");
        int scoreInt = Integer.valueOf(score);
        if ((scoreInt < 1) || (scoreInt > 6)) {
            resp.getWriter().println("niepoprawne dane");
            return;
        }
        HttpSession session = req.getSession();
        List<Integer> scores = new LinkedList<>();
        if (session.getAttribute("scores") != null) {
            scores = (List<Integer>) session.getAttribute("scores");
        }
        scores.add(scoreInt);
        session.setAttribute("scores", scores);
        doGet(req, resp);
    }
}

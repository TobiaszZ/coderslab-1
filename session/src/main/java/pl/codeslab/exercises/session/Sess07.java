package pl.codeslab.exercises.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebServlet(value = "/Sess07") public class Sess07 extends HttpServlet {

    private static class Country {
        private String country;
        private String capitol;

        public Country(String country, String capitol) {
            this.country = country;
            this.capitol = capitol;
        }
    }

    private static final List<Country> ANSWERS;

    static {
        ANSWERS = Arrays
                .asList(new Country("Niemcy", "Berlin"), new Country("Czechy", "Praga"), new Country("Słowacja", "Bratysława"), new Country("Ukraina", "Kijów"),
                        new Country("Białoruś", "Mińsk"), new Country("Litwa", "Wilno"), new Country("Rosja", "Moskwa"));
    }

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer i = (Integer) session.getAttribute("i");
        if (i == null) {
            i = 0;
        }
        Integer answers = (Integer) session.getAttribute("answers");
        if (answers == null) {
            answers = 0;
        }
        Boolean lastAnswer = (Boolean) session.getAttribute("lastAnswer");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        if (lastAnswer != null) {
            writer.append("<p>Odpowiedź " + (lastAnswer ? "poprawna" : "niepoprawna") + "</p>");
        }
        if (i < ANSWERS.size()) {
            writer.append("<form method=\"post\"><label>Podaj stolicę dla państwa: " + ANSWERS.get(i).country
                    + " <input name=\"capitol\"></label><input type=\"submit\"></form>");
        } else {
            writer.append("<p>Poprawnych odpowiedzi: " + answers + "</p>");
        }
        writer.append("</body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer i = (Integer) session.getAttribute("i");
        if (i == null) {
            i = 0;
        }
        Integer answers = (Integer) session.getAttribute("answers");
        if (answers == null) {
            answers = 0;
        }
        request.setCharacterEncoding("utf-8");
        if (Objects.equals(request.getParameter("capitol"), ANSWERS.get(i).capitol)) {
            ++answers;
            session.setAttribute("lastAnswer", true);
        } else {
            session.setAttribute("lastAnswer", false);
        }
        ++i;
        session.setAttribute("i", i);
        session.setAttribute("answers", answers);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("Sess07");
    }

}

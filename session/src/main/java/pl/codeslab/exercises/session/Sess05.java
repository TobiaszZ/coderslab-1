package pl.codeslab.exercises.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;

@WebServlet(value = "/Sess05") public class Sess05 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        Random random = new Random();
        int a = random.nextInt(101);
        int b = random.nextInt(101);
        int captcha = a + b;
        request.getSession().setAttribute("captcha", captcha);
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<form method=\"post\"><label>Imię: <input name=\"firstName\"></label>" + "<label>Nazwisko: <input name=\"lastName\"></label>"
                + "<label>Email: <input name=\"email\"></label>" + "<label>Wpisz poniżej sumę " + a + " + " + b + ": <input name=\"captcha\"></label>"
                + "<input type=\"submit\"></form>");
        writer.append("</body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int captcha = (int) session.getAttribute("captcha");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body><p>");
        if (Objects.equals(captcha, Integer.valueOf(request.getParameter("captcha")))) {
            writer.append("captcha poprawna");
        } else {
            writer.append("captcha niepoprawna");
        }
        writer.append("</p></body></html>");
    }

}

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

@WebServlet(value = "/Sess06") public class Sess06 extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        Random random = new Random();
        int a = random.nextInt(981) + 20;
        int b = random.nextInt(981) + 20;
        request.getSession().setAttribute("a", a);
        request.getSession().setAttribute("b", b);
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<p>a = "+a+"</p>");
        writer.append("<p>b = "+b+"</p>");
        writer.append("<form method=\"post\"><label>dodawanie: <input name=\"plus\"></label>" + "<label>odejmowanie: <input name=\"minus\"></label>"
                + "<label>mnożenie: <input name=\"times\"></label>" + "<input type=\"submit\"></form>");
        writer.append("</body></html>");
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int a = (int) session.getAttribute("a");
        int b = (int) session.getAttribute("b");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        int plus = Integer.valueOf(request.getParameter("plus"));
        int minus = Integer.valueOf(request.getParameter("minus"));
        int times = Integer.valueOf(request.getParameter("times"));
        writer.append("<p>" + a + " + " + b + " = " + plus + " " + (Objects.equals(plus, a + b) ? "Correct" : "Wrong") + "</p>");
        writer.append("<p>" + a + " - " + b + " = " + minus + " " + (Objects.equals(minus, a - b) ? "Correct" : "Wrong") + "</p>");
        writer.append("<p>" + a + " * " + b + " = " + times + " " + (Objects.equals(times, a * b) ? "Correct" : "Wrong") + "</p>");
        writer.append("</p></body></html>");
    }

}

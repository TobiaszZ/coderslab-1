package pl.codeslab.exercises.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/Sess04") public class Sess04 extends HttpServlet {

    private class Product {
        private String name;
        private int quantity;
        private double price;

        public Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        showTable(request, response);
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products == null) {
            products = new LinkedList<>();
        }
        Product product = new Product(request.getParameter("name"), Integer.valueOf(request.getParameter("quantity")),
                Integer.valueOf(request.getParameter("price")));
        products.add(product);
        session.setAttribute("products", products);
        showTable(request, response);
    }

    private void showTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products == null) {
            products = new LinkedList<>();
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.append("<ul>");
        double sum = 0;
        for (Product product : products) {
            double price = product.quantity * product.price;
            writer.append("<li>" + product.name + " - " + product.quantity + " x " + product.price + " = " + price + " zł</li>");
            sum += price;
        }
        writer.append("<li>SUMA: " + sum + " zł</li>");
        writer.append("</ul>");
        writer.append("</body></html>");
    }

}

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminViewLaundryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Order> orders = new ArrayList<>();
        
        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "SELECT * FROM orders";
                try (PreparedStatement pst = conn.prepareStatement(query);
                     ResultSet rs = pst.executeQuery()) {

                    while (rs.next()) {
                        Order order = new Order();
                        order.setOrderID(rs.getInt("OrderID"));
                        order.setUserID(rs.getInt("UserID"));
                        order.setPickUp(rs.getString("PickUp"));
                        order.setTime(rs.getString("Time"));

                        orders.add(order);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }

        request.setAttribute("orders", orders);
        request.getRequestDispatcher("AdminViewLaundry.jsp").forward(request, response);
    }
}
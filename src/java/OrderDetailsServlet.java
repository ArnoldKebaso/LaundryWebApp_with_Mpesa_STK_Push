/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
//import jakarta.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Krafty Coder
 */
@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
@SuppressWarnings("empty-statement")
@Override
protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pickUp = request.getParameter("pickUp");
        String time = request.getParameter("time");


        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users ";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "INSERT INTO order_details(pickUp, time) VALUES (?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, pickUp);
                    pst.setString(2, time);

                    int rowsaffected = pst.executeUpdate();
                 if(rowsaffected > 0){
                     response.sendRedirect("address.jsp");
                 }else{
                     response.sendRedirect("order_details.jsp");
                 }   
                    
                    
                  
         
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}

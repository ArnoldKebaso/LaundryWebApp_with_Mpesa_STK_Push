//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import models.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
////@WebServlet("/UserServlet")
////public class UserServlet extends HttpServlet {
////    private static final long serialVersionUID = 1L;
////
////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String action = request.getParameter("action");
////        if (action == null) {
////            action = "";
////        }
////
////        switch (action) {
////            case "add":
////                addUser(request, response);
////                break;
////            case "edit":
////                editUser(request, response);
////                break;
////            case "delete":
////                deleteUser(request, response);
////                break;
////            default:
////                listUsers(request, response);
////                break;
////        }
////    }
////
////    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        List<User> userList = new ArrayList<>();
////        try (Connection con = getConnection()) {
////            String sql = "SELECT * FROM laundryuser";
////            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
////                while (rs.next()) {
////                    User user = new User();
////                    user.setId(rs.getInt("id"));
////                    user.setUsername(rs.getString("username"));
////                    user.setEmail(rs.getString("email"));
////                    user.setUserType(rs.getString("userType"));
////                    user.setPhone(rs.getString("phone"));
////                    userList.add(user);
////                }
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////        request.setAttribute("userList", userList);
////        request.getRequestDispatcher("ManageUsers.jsp").forward(request, response);
////    }
////
////    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String username = request.getParameter("username");
////        String email = request.getParameter("email");
////        String password = request.getParameter("password");
////        String userType = request.getParameter("userType");
////        String phone = request.getParameter("phone");
////
////        try (Connection con = getConnection()) {
////            String sql = "INSERT INTO laundryuser (username, email, password, userType, phone) VALUES (?, ?, ?, ?, ?)";
////            try (PreparedStatement ps = con.prepareStatement(sql)) {
////                ps.setString(1, username);
////                ps.setString(2, email);
////                ps.setString(3, password);
////                ps.setString(4, userType);
////                ps.setString(5, phone);
////                ps.executeUpdate();
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////        listUsers(request, response);
////    }
////
////    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////        // Handle edit functionality
////        // Retrieve the user by id, set it in the request, and forward to a new JSP to edit the user
////    }
////
////    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////
////        try (Connection con = getConnection()) {
////            String sql = "DELETE FROM laundryuser WHERE id = ?";
////            try (PreparedStatement ps = con.prepareStatement(sql)) {
////                ps.setInt(1, id);
////                ps.executeUpdate();
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////        listUsers(request, response);
////    }
////
////    private Connection getConnection() throws SQLException {
////        String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
////        String user = "root";
////        String dbPassword = "mAjimaji21!!";
////        return DriverManager.getConnection(dbURL, user, dbPassword);
////    }
////}
//
//@WebServlet("/UserServlet")
//public class UserServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//
//        switch (action) {
//            case "add":
//                addUser(request, response);
//                break;
//            case "edit":
//                editUser(request, response);
//                break;
//            case "delete":
//                deleteUser(request, response);
//                break;
//            default:
//                listUsers(request, response);
//                break;
//        }
//    }
//
//    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<User> userList = new ArrayList<>();
//        try (Connection con = getConnection()) {
//            String sql = "SELECT * FROM users";
//            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
//                while (rs.next()) {
//                    User user = new User();
//                    user.setId(rs.getInt("id"));
//                    user.setUsername(rs.getString("username"));
//                    user.setEmail(rs.getString("email"));
//                    user.setUserType(rs.getString("userType"));
//                    user.setPhone(rs.getString("phone"));
//                    userList.add(user);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        request.setAttribute("userList", userList);
//        request.getRequestDispatcher("ManageUsers.jsp").forward(request, response);
//    }
//
//    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String userType = request.getParameter("userType");
//        String phone = request.getParameter("phone");
//
//        try (Connection con = getConnection()) {
//            String sql = "INSERT INTO users (username, email, password, userType, phone) VALUES (?, ?, ?, ?, ?)";
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, username);
//                ps.setString(2, email);
//                ps.setString(3, password);
//                ps.setString(4, userType);
//                ps.setString(5, phone);
//                ps.executeUpdate();
//
//                // Send email notification
//                String subject = "Welcome to ARC Laundry";
//                String message = "Dear " + username + ",\n\nYour account has been created successfully.\n\nRegards,\nARC Laundry Team";
//                EmailUtility.sendEmail(email, subject, message);
//            }
//        } catch (SQLException | MessagingException e) {
//            e.printStackTrace();
//        }
//
//        listUsers(request, response);
//    }
//
//    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        // Retrieve user details from request parameters and update the user in the database
//        // Send email notification if needed
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        try (Connection con = getConnection()) {
//            String sql = "DELETE FROM users WHERE id = ?";
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setInt(1, id);
//                ps.executeUpdate();
//
//                // Send email notification
//                String email = request.getParameter("email");
//                String subject = "Account Deleted";
//                String message = "Your account has been deleted successfully.\n\nRegards,\nARC Laundry Team";
//                EmailUtility.sendEmail(email, subject, message);
//            }
//        } catch (SQLException | MessagingException e) {
//            e.printStackTrace();
//        }
//
//        listUsers(request, response);
//    }
//
//    private Connection getConnection() throws SQLException {
//        String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
//        String user = "root";
//        String dbPassword = "mAjimaji21!!";
//        return DriverManager.getConnection(dbURL, user, dbPassword);
//    }
//}

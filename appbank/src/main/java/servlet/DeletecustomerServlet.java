package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletecustomerServlet")
public class DeletecustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        

        try {
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata", "root", "Abinaya@2004");
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }

            String sql = "DELETE FROM customer WHERE account_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, accountNumber);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                request.setAttribute("message", "Customer deleted successfully.");
            } else {
                request.setAttribute("message", "Failed to delete customer. Please try again.");
            }

           
       

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error deleting customer. Please try again.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } 
        
    }
}

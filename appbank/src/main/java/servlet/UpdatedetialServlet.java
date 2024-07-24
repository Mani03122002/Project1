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

@WebServlet("/updatedetailServlet")
public class UpdatedetialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailId = request.getParameter("emailId");
        String accountType = request.getParameter("accountType");
        String dob = request.getParameter("dob");
        String idProof = request.getParameter("idProof");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata", "root", "Abinaya@2004");
            String sql = "UPDATE customer SET full_name = ?, address = ?, mobile_no = ?, email_id = ?, account_type = ?, date_of_birth = ?, id_proof = ? WHERE account_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, mobileNumber);
            pstmt.setString(4, emailId);
            pstmt.setString(5, accountType);
            pstmt.setString(6, dob);
            pstmt.setString(7, idProof);
            pstmt.setString(8, accountNumber);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("message", "Customer details updated successfully!");
            } else {
                request.setAttribute("message", "Error updating customer details. Please try again.");
            }
            request.getRequestDispatcher("updatedetails.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error updating customer details. Please try again.");
            request.getRequestDispatcher("updatedetails.jsp").forward(request, response);
        } 
    }
}

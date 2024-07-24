package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkacntdetailServlet")
public class UpdatelogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata", "root", "Abinaya@2004");
            String sql = "SELECT * FROM customer WHERE account_no = ?";
            PreparedStatement  ps = con.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ResultSet rs= ps.executeQuery();
            if (rs.next()) {
                request.setAttribute("accountNumber", accountNumber);
                request.setAttribute("name", rs.getString("full_name"));
                request.setAttribute("address", rs.getString("address"));
                request.setAttribute("mobileNumber", rs.getString("mobile_no"));
                request.setAttribute("emailId", rs.getString("email_id"));
                request.setAttribute("accountType", rs.getString("account_type"));
                request.setAttribute("dob", rs.getString("date_of_birth"));
                request.setAttribute("idProof", rs.getString("id_proof"));
                request.getRequestDispatcher("updatedetails.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Account not found.");
                request.getRequestDispatcher("updatelog.jsp").forward(request, response);
            }
        }  catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration: " + e.getMessage());
        }
    }
}

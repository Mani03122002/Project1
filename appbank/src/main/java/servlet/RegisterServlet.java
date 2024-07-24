package servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.security.SecureRandom;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name = request.getParameter("name");
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailId = request.getParameter("emailId");
        String accountType = request.getParameter("accountType");
        String initialAmount = request.getParameter("initialAmount");
        String dob = request.getParameter("dob");
        String idProof = request.getParameter("idProof");
        
        SecureRandom random = new SecureRandom();
        int password = 1000 + random.nextInt(9000);
        String passwordstr = Integer.toString(password);
        
        long timestamp = System.currentTimeMillis();
        int randomNum = 100 + random.nextInt(900);
        String accountNumber = String.valueOf(timestamp) + randomNum;
        
        
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata","root","Abinaya@2004");
          String sql = "INSERT INTO customer (full_name, address, mobile_no, email_id, account_type, initial_balance, date_of_birth, id_proof, account_no, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          PreparedStatement ps = con.prepareStatement (sql);
          ps.setString(1, name);
          ps.setString(2, address);
          ps.setString(3, mobileNumber);
          ps.setString(4, emailId);
          ps.setString(5, accountType);
          ps.setString(6, initialAmount);
          ps.setString(7, dob);
          ps.setString(8, idProof);
          ps.setString(9, accountNumber);
          ps.setString(10,passwordstr);
          ps.executeUpdate();
          response.sendRedirect("adminnewregister.jsp?message=Account successfully registered! Your account number is: " + accountNumber + " and your Temp password is: " + password);
          
         
          
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration: " + e.getMessage());
        }
    }
}

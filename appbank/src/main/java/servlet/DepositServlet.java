package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/depositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String amountStr = request.getParameter("amount");
        double amount = Double.parseDouble(amountStr);
        
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata","root","Abinaya@2004");
          PreparedStatement ps = con.prepareStatement("UPDATE customer SET initial_balance=initial_balance+? WHERE account_no=?");
          ps.setDouble(1,amount);
          ps.setString(2, accountNumber);
          ps.executeUpdate();
          
          PreparedStatement psn= con.prepareStatement("INSERT INTO transactions (account_number, type, amount) VALUES (?, 'deposit', ?)");
          psn.setString(1, accountNumber);
          psn.setDouble(2, amount);
          psn.executeUpdate();
          
          response.sendRedirect("deposit.jsp?message=Deposit Successful!");
          
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error during deposit: " + e.getMessage());
        }
    }
}

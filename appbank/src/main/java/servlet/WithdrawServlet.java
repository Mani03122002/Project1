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
import java.sql.ResultSet;

@WebServlet("/withdrawServlet")
public class WithdrawServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String amountStr = request.getParameter("amount");
        double amount = Double.parseDouble(amountStr);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata", "root", "Abinaya@2004");

            // Check current balance
            PreparedStatement checkBalanceStmt = con.prepareStatement("SELECT initial_balance FROM customer WHERE account_no=?");
            checkBalanceStmt.setString(1, accountNumber);
            ResultSet rs = checkBalanceStmt.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("initial_balance");

                if (currentBalance >= amount) {
                    // Perform withdrawal
                    PreparedStatement updateBalanceStmt = con.prepareStatement("UPDATE customer SET initial_balance=initial_balance-? WHERE account_no=?");
                    updateBalanceStmt.setDouble(1, amount);
                    updateBalanceStmt.setString(2, accountNumber);
                    updateBalanceStmt.executeUpdate();

                    // Log the transaction
                    PreparedStatement logTransactionStmt = con.prepareStatement("INSERT INTO transactions (account_number, type, amount) VALUES (?, 'withdrawal', ?)");
                    logTransactionStmt.setString(1, accountNumber);
                    logTransactionStmt.setDouble(2, amount);
                    logTransactionStmt.executeUpdate();

                    // Get updated balance
                    double newBalance = currentBalance - amount;

                    response.sendRedirect("withdraw.jsp?message=Withdrawal Successful!&balance=" + newBalance);
                } else {
                    // Insufficient balance
                    response.sendRedirect("withdraw.jsp?message=Insufficient Balance! Current Balance: " + currentBalance);
                }
            } else {
                response.getWriter().println("Account not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error during withdrawal: " + e.getMessage());
        }
    }
}

package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/transactionServlet")
public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        List<Map<String, String>> transactions = new ArrayList<>();

        try {
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata", "root", "Abinaya@2004");
           PreparedStatement  ps=con.prepareStatement("SELECT * FROM transactions WHERE account_number = ?");
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, String> transaction = new HashMap<>();
                transaction.put("date", rs.getString("date"));
                transaction.put("type", rs.getString("type"));
                transaction.put("amount", rs.getString("amount"));
                transactions.add(transaction);
            }

            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("displayTransactions.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error retrieving transactions. Please try again.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

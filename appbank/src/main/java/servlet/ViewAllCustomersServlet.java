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

@WebServlet("/ViewAllCustomersServlet")
public class ViewAllCustomersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
        List<Map<String, String>> customers = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata", "root", "Abinaya@2004");
            String sql = "SELECT account_no, full_name, address, mobile_no, email_id, account_type, date_of_birth , id_proof FROM customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, String> customer = new HashMap<>();
                customer.put("accountNumber", rs.getString("account_no"));
                customer.put("name", rs.getString("full_name"));
                customer.put("address", rs.getString("address"));
                customer.put("mobileNumber", rs.getString("mobile_no"));
                customer.put("emailId", rs.getString("email_id"));
                customer.put("accountType", rs.getString("account_type"));
                customer.put("dob", rs.getString("date_of_birth"));
                customer.put("idProof", rs.getString("id_proof"));
                customers.add(customer);
            }

            request.setAttribute("customers", customers);
            request.getRequestDispatcher("viewAllCustomers.jsp").forward(request, response);

        } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


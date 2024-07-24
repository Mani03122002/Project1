package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BalanceServlet
 */
@WebServlet("/balanceServlet")
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int accountNo = Integer.parseInt(request.getParameter("accountNo"));
	String accountNo=request.getParameter("accountNo");
		
		
		
		
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abibankdata","root","Abinaya@2004");
		String sql = "SELECT inital_balance FROM customer WHERE account_no =?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,accountNo);
		ResultSet rs = statement.executeQuery();
		double balance=0.0;
		if(rs.next()) {
			 balance = rs.getDouble("initial_balance");
			request.setAttribute("balance",balance);
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/balance.jsp?message="+balance);
	    dispatcher.forward(request, response);
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
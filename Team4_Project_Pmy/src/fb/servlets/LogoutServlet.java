package fb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = req.getRequestDispatcher("./logout.jsp");
		rd.forward(req, res);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req
		, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		res.sendRedirect("./login");
	}
}

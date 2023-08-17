package fb.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fb.dao.MemberDao;

@WebServlet("/auth/findMyAccount")
public class FindMyAccountServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = req.getRequestDispatcher("./findMyAccount.jsp");
		rd.forward(req, res);
		
	}
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
        
    	Connection conn = null;
    	
        try {
        	
			String email = req.getParameter("email");
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			 // DAO를 통해 계정을 찾는 작업 수행
            String findAccount = memberDao.findMyAccountByEmail(email);
            
			if(findAccount == null) {
				req.setAttribute("failedLogin", "failedLogin");
				RequestDispatcher rd = 
						req.getRequestDispatcher("./findMyAccount.jsp");
					
				rd.forward(req, res);
			} else {
				// 결과를 JSP 페이지로 전달
				HttpSession session = req.getSession();
	            session.setAttribute("findAccount", findAccount);
				res.sendRedirect("./findPw");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
    }
}

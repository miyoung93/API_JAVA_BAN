package fb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fb.dao.MemberDao;
import fb.dto.MemberDto;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = req.getRequestDispatcher("./loginForm.jsp");
		rd.forward(req, res);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			String email = req.getParameter("email");
			String pwd = req.getParameter("password");
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			MemberDto memberDto = memberDao.findPwByEmail(email);
			
			//이메일 확인
			
			if(memberDto.getEmail().isEmpty()) {
				
				RequestDispatcher rd = 
						req.getRequestDispatcher("./loginFail.jsp");
					
					rd.forward(req, res);
				
			} else {
				
				memberDto = memberDao.memberLogin(email, pwd);
				req.setAttribute("memberDto", memberDto);
				
				if(memberDto == null){
					memberDto = memberDao.findPwByEmail(email);
					req.setAttribute("memberDto", memberDto);
					req.setAttribute("failedPwd", "failedPwd");
					
					RequestDispatcher rd = 
							req.getRequestDispatcher("./IdLogin.jsp");
						
						rd.forward(req, res);
						
				} else {
					HttpSession session = req.getSession();
					session.setAttribute("member", memberDto);
					
					res.sendRedirect("../board/list");
				}
			}
			
			
//			if(memberDto == null) {
//				RequestDispatcher rd = 
//						req.getRequestDispatcher("./loginFail.jsp");
//					
//					rd.forward(req, res);
//			} else if(memberDto.equals(obj)) {
//				
//			} else {
//				HttpSession session = req.getSession();
//				session.setAttribute("member", memberDto);
//				
//				res.sendRedirect("../board/list");
//			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
	}
	
}


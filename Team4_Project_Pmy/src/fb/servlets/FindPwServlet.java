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
import fb.dto.MemberDto;

@WebServlet("/auth/findPw")
public class FindPwServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = req.getRequestDispatcher("./findPw.jsp");
		rd.forward(req, res);
		
	}
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
        
    	Connection conn = null;
    	
        try {
        	HttpSession session = req.getSession();
			String email = (String) session.getAttribute("findAccount");
			
			String option = req.getParameter("pwd");
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
            MemberDto memberDto = memberDao.findPwByEmail(email);
            req.setAttribute("memberDto", memberDto);
            
            if(option.equals("option1")) {
            	req.getRequestDispatcher("./pwReminder.jsp").forward(req, res);
            }else if(option.equals("option2")) {
            	req.getRequestDispatcher("./IdLogin.jsp").forward(req, res);
            }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
    }
}

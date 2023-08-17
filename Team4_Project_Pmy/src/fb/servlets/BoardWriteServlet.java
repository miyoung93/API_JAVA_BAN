package fb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fb.dao.BoardDao;
import fb.dao.MemberDao;
import fb.dto.BoardDto;
import fb.dto.MemberDto;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("member") == null) {
				response.sendRedirect(request.getContextPath() + "/auth/login");
			}else {
				ServletContext sc = this.getServletContext();
				
				conn = (Connection) sc.getAttribute("conn");
				
				RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/board/board_write.jsp");
				
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			RequestDispatcher dispatcher 
				= request.getRequestDispatcher("/error.jsp");

			dispatcher.forward(request, response);
		}
	} // doGet 메서드 끝
	
	@Override
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			String writer = request.getParameter("writer");
			String subject = request.getParameter("subject");
			String email = request.getParameter("email");
			String content = request.getParameter("content");
			String pwd = request.getParameter("pwd");
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao membarDao = new MemberDao();
			membarDao.setConnection(conn);
			
			MemberDto memberDto = new MemberDto(); 
			memberDto = membarDao.memberLogin(email, pwd);
			
			BoardDao boardDao = new BoardDao();
			
			BoardDto boardDto = new BoardDto();
			boardDto.setMember_name(writer);
			boardDto.setSubject(subject);
			boardDto.setContent(content);
			if(memberDto == null) {
				request.setAttribute("failedWrite", "incorrectPwd");
				request.setAttribute("boardDto", boardDto);
				RequestDispatcher rd = 
					request.getRequestDispatcher("./board_write.jsp");
					
				rd.forward(request, response);
			}else {
				boardDao.setConnection(conn);
				boardDto.setMember_no(memberDto.getNo());
				boardDao.insertBoard(boardDto);
				
				response.sendRedirect("./list");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e);
			request.setAttribute("msg", "i'm sorry");
			RequestDispatcher dispatcher 
				= request.getRequestDispatcher("/Error.jsp");

			dispatcher.forward(request, response);
		}
		
	} // doPost 메서드 끝
	
}

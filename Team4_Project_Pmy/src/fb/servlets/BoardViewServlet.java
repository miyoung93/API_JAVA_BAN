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

@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet{

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
				int no = Integer.parseInt(request.getParameter("no"));
				
				ServletContext sc = this.getServletContext();
				
				conn = (Connection) sc.getAttribute("conn");
				
				BoardDao boardDao = new BoardDao();
				boardDao.setConnection(conn);
				BoardDto boardDto = boardDao.boardSelectOne(no);
				boardDao.increaseHits(no);
				MemberDao memberDao = new MemberDao();
				memberDao.setConnection(conn);
				MemberDto memberDto = memberDao.getInfoByNo(boardDto.getMember_no());
				memberDto.setNo(boardDto.getMember_no());
				request.setAttribute("memberDto", memberDto);
				request.setAttribute("boardDto", boardDto);
				
				RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/board/board_view.jsp");
				
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
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			int member_no = Integer.parseInt(request.getParameter("member_no"));
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao membarDao = new MemberDao();
			membarDao.setConnection(conn);
			
			MemberDto memberDto = new MemberDto(); 
			memberDto = membarDao.memberLogin(email, pwd);
			
			BoardDao boardDao = new BoardDao();
			
			BoardDto boardDto = new BoardDto();
			boardDto.setSubject(subject);
			boardDto.setContent(content);
			boardDto.setBoard_no(board_no);
			if(memberDto == null) {
				request.setAttribute("failedWrite", "incorrectPwd");
				memberDto = new MemberDto();
				memberDto.setFull_name(writer);
				memberDto.setEmail(email);
				memberDto.setNo(member_no);
				request.setAttribute("memberDto", memberDto);
				request.setAttribute("boardDto", boardDto);
				RequestDispatcher rd = 
					request.getRequestDispatcher("./board_view.jsp");
					
				rd.forward(request, response);
			}else {
				boardDao.setConnection(conn);
				boardDao.boardModify(boardDto);
				request.setAttribute("no", board_no);
				response.sendRedirect("./view?no=" + board_no);
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

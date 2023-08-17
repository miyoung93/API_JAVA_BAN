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
import fb.dto.BoardDto;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet{

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
				
				BoardDao boardDao = new BoardDao();
				boardDao.setConnection(conn);
				HashMap<Integer, ArrayList<BoardDto>> boardMap = null;
				
				boardMap = boardDao.selectList();
				
				int selectIndex = 1;
				request.setAttribute("selectIndex", selectIndex);
				request.setAttribute("boardMap", boardMap);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/board/board_list.jsp");
				
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e);
			request.setAttribute("msg", "i'm sorry");
			RequestDispatcher dispatcher 
				= request.getRequestDispatcher("/Error.jsp");

			dispatcher.forward(request, response);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn);
			HashMap<Integer, ArrayList<BoardDto>> boardMap = null;
			
			boardMap = boardDao.selectList();
			int selectIndex = Integer.parseInt(request.getParameter("selectIndex"));
			request.setAttribute("selectIndex", selectIndex);
			request.setAttribute("boardMap", boardMap);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/board/board_list.jsp");
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e);
			request.setAttribute("msg", "i'm sorry");
			RequestDispatcher dispatcher 
				= request.getRequestDispatcher("/Error.jsp");

			dispatcher.forward(request, response);
		}
	}
	
}

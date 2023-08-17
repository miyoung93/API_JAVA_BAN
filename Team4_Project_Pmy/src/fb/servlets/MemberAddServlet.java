package fb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fb.dao.MemberDao;
import fb.dto.MemberDto;


@WebServlet("/join/add")
public class MemberAddServlet extends HttpServlet {

	// 회원등록화면
	@Override
	protected void doGet(HttpServletRequest request
		, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("./join.jsp");
		
	}

	// 데이터베이스에 데이터 추가, 회원정보 저장
	@Override
	protected void doPost(HttpServletRequest req
		, HttpServletResponse res)
			throws ServletException, IOException {

		Connection conn = null;
		
		try {
			String lastName = req.getParameter("last_name");
			String firstName = req.getParameter("first_name");
			String email = req.getParameter("email");
			String password = req.getParameter("pwd");
			String gender = req.getParameter("gender");
			String birthdayYear = req.getParameter("birthdayYear");
			String birthdayMonth = req.getParameter("birthdayMonth");
			String birthdayDay = req.getParameter("birthdayDay");
			
			// 문자열을 정수로 변환
			int year = Integer.parseInt(birthdayYear);
			int month = Integer.parseInt(birthdayMonth);
			int day = Integer.parseInt(birthdayDay);

			// Calendar 객체를 사용하여 java.util.Date 생성
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.set(year, month - 1, day);  // month는 0부터 시작하므로 1을 빼줌

			java.util.Date birth_date = calendar.getTime();
			
			MemberDto memberDto = new MemberDto();
			
			memberDto.setLast_name(lastName);
			memberDto.setFirst_name(firstName);
			memberDto.setEmail(email);
			memberDto.setPwd(password);
			memberDto.setGender(gender);
			memberDto.setBirth_date(birth_date);
			
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			
			memberDao.setConnection(conn);
			
			int resultNum = 0;
			
			resultNum = memberDao.memberInsert(memberDto);
			
			res.sendRedirect("../auth/login");

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = 
					req.getRequestDispatcher("/Error.jsp");
				
			rd.forward(req, res);
		}
	}

}

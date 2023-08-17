package fb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import fb.dto.BoardDto;

public class BoardDao {

	private Connection connection;
	
	public void setConnection(Connection conn) {
		this.connection = conn;
	}
	
	public HashMap<Integer, ArrayList<BoardDto>> selectList() throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT BOARD_NO, BOARD_SUBJECT, BOARD_CRE_DATE,";
			sql += " BOARD_HITS, WRITER_FULL_NAME";
			sql += " FROM BOARD";
			sql += " ORDER BY BOARD_NO DESC";
			
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			int board_no = 0;
			String subject = "";
			Date cre_date = null;
			int hits = 0;
//			int member_no = 0;
			String member_name = "";
			
			HashMap<Integer, ArrayList<BoardDto>> boardMap =
					new HashMap<Integer, ArrayList<BoardDto>>();
			int listCount = 0;
			int mapCount = 1;
			
			ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
			while (true) {
				if(rs.next()) {
					if(listCount < 10) {
						board_no = rs.getInt("BOARD_NO");
						subject = rs.getString("BOARD_SUBJECT");
						member_name = rs.getString("WRITER_FULL_NAME");
						cre_date = rs.getDate("BOARD_CRE_DATE");
						hits = rs.getInt("BOARD_HITS");
						
						BoardDto boardDto = new BoardDto();
						boardDto.setBoard_no(board_no);
						boardDto.setSubject(subject);
						boardDto.setMember_name(member_name);
						boardDto.setCre_date(cre_date);
						boardDto.setHits(hits);
						
						boardList.add(boardDto);
						
						listCount++;
					}else {
						boardMap.put(mapCount++, boardList);
						listCount = 0;
						boardList = new ArrayList<BoardDto>();
					}
				}else { //0, 5, 15, 20
					if(mapCount == 1 || listCount != 0) {
						boardMap.put(mapCount, boardList);
						break;
					}
				}
			}
			
			
			return boardMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	} // 회원목록 끝
	
	// 회원등록
	public void insertBoard(BoardDto boardDto) throws Exception{
		
		PreparedStatement pstmt = null;
		
		try {
			String writer = boardDto.getMember_name();
			String subject = boardDto.getSubject();
			String content = boardDto.getContent();
			int member_no = boardDto.getMember_no();
			
			String sql = "";
			
			sql += "INSERT INTO BOARD";
			sql += " (BOARD_NO, BOARD_SUBJECT, BOARD_CONTENT, BOARD_CRE_DATE,";
			sql += " WRITER_MEMBER_NO, WRITER_FULL_NAME)";
			sql += " VALUES(SEQ_Board_board_no.NEXTVAL, ?, ?, SYSDATE,";
			sql	+= " ?, ?)";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, member_no);
			pstmt.setString(4, writer);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} //if 종료
		}
		
	}
	
	
	public BoardDto boardSelectOne(int no) throws Exception{
		BoardDto boardDto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql;
			
			sql = "SELECT BOARD_SUBJECT, BOARD_CONTENT, WRITER_MEMBER_NO, BOARD_NO";
			sql += " FROM BOARD";
			sql += " WHERE BOARD_NO = ?";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			String subject = "";
			String content = "";
			int member_no = 0;
			int board_no = 0;
			
			if(rs.next()) {
				subject = rs.getString("BOARD_SUBJECT");
				content = rs.getString("BOARD_CONTENT");
				member_no = rs.getInt("WRITER_MEMBER_NO");
				board_no = rs.getInt("BOARD_NO");
				
				boardDto = new BoardDto();
				boardDto.setSubject(subject);;
				boardDto.setContent(content);
				boardDto.setMember_no(member_no);
				boardDto.setBoard_no(board_no);
				
			} else {
				throw new Exception("해당 게시물을 찾을 수 없습니다.");
			}
			
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} //finally end
		
		return boardDto;
	}
	
	public void boardModify(BoardDto boardDto) throws Exception {
		
		PreparedStatement pstmt = null;
		
		String sql = "";
		sql = "UPDATE BOARD";
		sql += " SET BOARD_SUBJECT = ?, BOARD_CONTENT = ?";
		sql += " WHERE BOARD_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getBoard_no());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void increaseHits(int no) throws Exception {
		
		PreparedStatement pstmt = null;
		
		String sql = "";
		sql = "UPDATE BOARD";
		sql += " SET BOARD_HITS = BOARD_HITS + 1";
		sql += " WHERE BOARD_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public BoardDto boardExist(String email, String pwd) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MNAME, EMAIL";
		sql += " FROM MEMBERS";
		sql += " WHERE EMAIL = ?";
		sql += " AND PWD = ?";
		
		String name = "";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			int colIndex = 1;
			
			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);
			
			rs = pstmt.executeQuery();
			
			BoardDto boardDto = new BoardDto();
			
			if(rs.next()) {
				email = rs.getString("email");
				name = rs.getString("mname");
				
//				boardDto.setName(name);
//				boardDto.setEmail(email);
				
				return boardDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // finally 종료
		return null;
	}
	
}


package fb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fb.dto.MemberDto;

	public class MemberDao {

		private Connection connection;
		
		public void setConnection(Connection conn) {
			this.connection = conn;
		}
		

		// 회원등록
		public int memberInsert(MemberDto memberDto) throws Exception{
			int resultNum = 0;
			
			PreparedStatement pstmt = null;
			
			try {
		
				String lastName = memberDto.getLast_name();
		        String firstName = memberDto.getFirst_name();
		        String email = memberDto.getEmail();
		        String password = memberDto.getPwd();
		        String gender = memberDto.getGender();
		        Date birth_date = memberDto.getBirth_date();
		        java.sql.Date sqlBirthDate = new java.sql.Date(birth_date.getTime());
				String sql = "";
				
				sql += "INSERT INTO MEMBER";
				sql += "(MEMBER_NO, FIRST_NAME, LAST_NAME, EMAIL," + 
						"    PASSWORD, BIRTH_DATE, GENDER, FULL_NAME)";
				sql += "VALUES(SEQ_Member_member_no.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
				
				pstmt = connection.prepareStatement(sql);
				
				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				pstmt.setString(3, email);
				pstmt.setString(4, password);
				pstmt.setDate(5, sqlBirthDate);
				pstmt.setString(6, gender);
				pstmt.setString(7, firstName + lastName);
				
				resultNum = pstmt.executeUpdate();

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
			
			return resultNum;
		}
		
		//로그인
		public MemberDto memberExist(String email, String pwd) throws Exception{
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "";
			
			sql += "SELECT FULL_NAME, EMAIL";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			sql += " AND PWD = ?";
			
			String name = "";
			
			try {
				pstmt = connection.prepareStatement(sql);
				
				int colIndex = 1;
				
				pstmt.setString(colIndex++, email);
				pstmt.setString(colIndex, pwd);
				
				rs = pstmt.executeQuery();
				
				MemberDto memberDto = new MemberDto();
				
				if(rs.next()) {
					
					name = rs.getString("FULL_NAME");
					email = rs.getString("EMAIL");
					
					memberDto.setFull_name(name);
					memberDto.setEmail(email);
					
					return memberDto;
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
		}//end
	}

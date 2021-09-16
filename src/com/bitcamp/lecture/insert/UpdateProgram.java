package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bitcamp.lecture.comm.Member;

public class UpdateProgram {
	static final String URL ="jdbc:mysql://localhost:3306/lecture";
	static final String ID ="root";
	static final String PW ="dkdlxl";
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement preStmt =null;
	
		//UI쪽 인터페이스를 통해서 CRUD 관련 데이터를 전달 받는다.
		Member member =new Member();
		member.setId("★★★★★2");
		member.setPwd("*****2");
		member.setName("테스터20915");
		member.setGender("M");
		
		
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			/* DB 연결
			 */
			con = DriverManager.getConnection(URL, ID, PW);
			System.out.println("Successfully Connection!");
			/* 쿼리 실행
			 */
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER)VALUES(?,?,?,?)";
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1,member.getId());		//DB에서는 인덱스가 1부터 시작한다.
			preStmt.setString(2,member.getPwd());		//DB에서는 인덱스가 1부터 시작한다.
			preStmt.setString(3,member.getName());		//DB에서는 인덱스가 1부터 시작한다.
			preStmt.setString(4,member.getGender());		//DB에서는 인덱스가 1부터 시작한다.
			
			//stmt.executeQuery(sql);  select일때만
			//나머진 다 executeUpdate() 사용	
			int cnt = preStmt.executeUpdate(); //getset으로 구현할때는 ()안에 sql이 없어야한다.
			System.out.println("Query OK"+ cnt +"row affected.");
			
		
		
			
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			
		}finally {
			try {
				if(con != null&& !con.isClosed()) {
					
					preStmt.close();
					con.close();
					System.out.println("리소스 해제 완료");
				}
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				
			}
			
		}
	}

}

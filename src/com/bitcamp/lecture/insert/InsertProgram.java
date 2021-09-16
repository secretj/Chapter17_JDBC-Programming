package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProgram {
	static final String URL ="jdbc:mysql://221.148.138.87:3306/lecture";
	static final String ID ="bitcamp";
	static final String PW ="1234";
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
	
	
		
		
		
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			/* DB 연결
			 */
			con = DriverManager.getConnection(URL, ID, PW);
			System.out.println("Successfully Connection!");
			/* 쿼리 실행
			 */
			stmt = con.createStatement();
			
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER)VALUES('SecRet_JIN2','12345','TESTER_PARK2','M')";
			
			//stmt.executeQuery(sql);  select일때만
			//나머진 다 executeUpdate() 사용	
			int cnt = stmt.executeUpdate(sql);
			System.out.println("Query OK"+ cnt +"row affected.");
			
		
		
			
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			
		}finally {
			try {
				if(con != null&& !con.isClosed()) {
					
					stmt.close();
					con.close();
					System.out.println("리소스 해제 완료");
				}
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				
			}
			
		}
	}

}

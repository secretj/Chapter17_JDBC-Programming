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
	
		//UI�� �������̽��� ���ؼ� CRUD ���� �����͸� ���� �޴´�.
		Member member =new Member();
		member.setId("�ڡڡڡڡ�2");
		member.setPwd("*****2");
		member.setName("�׽���20915");
		member.setGender("M");
		
		
		try {
			// ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			/* DB ����
			 */
			con = DriverManager.getConnection(URL, ID, PW);
			System.out.println("Successfully Connection!");
			/* ���� ����
			 */
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER)VALUES(?,?,?,?)";
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1,member.getId());		//DB������ �ε����� 1���� �����Ѵ�.
			preStmt.setString(2,member.getPwd());		//DB������ �ε����� 1���� �����Ѵ�.
			preStmt.setString(3,member.getName());		//DB������ �ε����� 1���� �����Ѵ�.
			preStmt.setString(4,member.getGender());		//DB������ �ε����� 1���� �����Ѵ�.
			
			//stmt.executeQuery(sql);  select�϶���
			//������ �� executeUpdate() ���	
			int cnt = preStmt.executeUpdate(); //getset���� �����Ҷ��� ()�ȿ� sql�� ������Ѵ�.
			System.out.println("Query OK"+ cnt +"row affected.");
			
		
		
			
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			
		}finally {
			try {
				if(con != null&& !con.isClosed()) {
					
					preStmt.close();
					con.close();
					System.out.println("���ҽ� ���� �Ϸ�");
				}
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				
			}
			
		}
	}

}

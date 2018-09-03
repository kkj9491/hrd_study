package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.study.model.Member;

public class HRDShopDao {

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "sys as sysdba", "1111");
		return con;
	}
	
	public int getNextMemberId() throws Exception {
		
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		if (conn != null) {
			String sql = "select member_seq.nextval from dual";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				result = -1;
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			conn.close();
		}
		
		return result;
	}
	
	public boolean insertMember(Member member) throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		
		int result = 0;
		boolean bResult = false;
		
		if (conn != null && member != null) {
			String sql = "insert into member_tbl_02 (custno, custname, phone, address, joindate, grade, city)" + 
					"values (?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getMember_num());
			ps.setString(2, member.getMember_name());
			ps.setString(3, member.getMember_phone());
			ps.setString(4, member.getMember_address());
			ps.setDate(5, member.getMember_join_date());
			ps.setString(6, member.getMember_title());
			ps.setString(7, member.getMember_city());
			result = ps.executeUpdate();
			
			if (result > 0) {
				bResult = true;
			}
			
			if (ps != null) {
				ps.close();
			}
			
			conn.close();
		}
		
		return bResult;
	}

	public List<Member> listMember() throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		List<Member> list = null;
		
		if (conn != null) {
			String sql = "select * from member_tbl_02 order by custno";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			list = new ArrayList<> ();
			
			while (rs.next()) {
				Member member = new Member();
				member.setMember_num(rs.getInt(1));
				member.setMember_name(rs.getString(2));
				member.setMember_phone(rs.getString(3));
				member.setMember_address(rs.getString(4));
				member.setMember_join_date(rs.getDate(5));
				member.setMember_title(rs.getString(6));
				member.setMember_city(rs.getString(7));
				
				list.add(member);
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			conn.close();
		}
		
		return list;
	}
}

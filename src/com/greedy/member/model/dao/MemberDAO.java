package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {

	private Properties prop;

	public MemberDAO() {
		this.prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));

		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNewMember(Connection con, MemberDTO member) {

		String query = prop.getProperty("insertMember");

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setInt(8, member.getAge());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}

		return result;
	}

	public List<MemberDTO> selectMemberList(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList = null;

		String query = prop.getProperty("selectMemberList");


		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			memberList = new ArrayList<>();

			while(rset.next()) {

				MemberDTO row = new MemberDTO();

				row.setId(rset.getString("MEMBER_ID"));
				row.setPwd(rset.getString("MEMBER_PWD"));
				row.setName(rset.getString("MEMBER_NAME"));
				row.setGender(rset.getString("GENDER"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setAddress(rset.getString("ADDRESS"));
				row.setAge(Integer.parseInt(rset.getString("AGE")));
				memberList.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return memberList;

	}




	public MemberDTO selectMemberId(Connection con, String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member =null;
		
		String query =prop.getProperty("selectMemberId");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new MemberDTO();
				
				member.setNumber(rset.getInt("Member_No"));
				member.setId(rset.getString("Member_Id"));
				member.setPwd(rset.getString("Member_Pwd"));
				member.setName(rset.getString("Member_Name"));
				member.setGender(rset.getString("Gender"));
				member.setEmail(rset.getString("Email"));
				member.setPhone(rset.getString("Phone"));
				member.setAddress(rset.getString("Address"));
				member.setAge(Integer.parseInt(rset.getString("Age")));
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return member;
	}

	public List<MemberDTO> findGender(Connection con,String gender) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList =null;
				
		String query = prop.getProperty("findGender");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, gender);
			rset = pstmt.executeQuery();
			memberList = new ArrayList<>();
			while(rset.next()) {

				MemberDTO row = new MemberDTO();

				row.setId(rset.getString("MEMBER_ID"));
				row.setPwd(rset.getString("MEMBER_PWD"));
				row.setName(rset.getString("MEMBER_NAME"));
				row.setGender(rset.getString("GENDER"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setAddress(rset.getString("ADDRESS"));
				row.setAge(Integer.parseInt(rset.getString("AGE")));
				memberList.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			
		}
		
		
		return memberList;
	}

	public int updatePassword(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updatePassword");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateId(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateId");
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getId());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		return result;
	}

	public int updatePhone(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updatePhone");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getPhone());
			pstmt.setString(2, member.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateAddress(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateAddress");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getAddress());
			pstmt.setString(2, member.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
	}

	public int deleteMember(Connection con, String id) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

	

	

	
}

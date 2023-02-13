package com.greedy.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.rollback;


public class MemberService {

	private MemberDAO memberDAO = new MemberDAO();
	
	public boolean createNewMember(MemberDTO member) {
		
		Connection con = getConnection();
		
		int result = memberDAO.insertNewMember(con, member);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}
	
	public List<MemberDTO> findAllMembers(){
		
		Connection con = getConnection();
		
		List<MemberDTO> memberList = memberDAO.selectMemberList(con);
		
		close(con);
		
		return memberList;
		
	}
	
}

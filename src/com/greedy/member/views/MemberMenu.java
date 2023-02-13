package com.greedy.member.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.greedy.member.controller.MemberController;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		
		MemberController memberController = new MemberController();
		
		do {
			System.out.println("\n *** 회원 관리 프로그램 *** \n");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 성별로 회원 조회");
			System.out.println("5. 암호 수정");
			System.out.println("6. 이메일 변경");
			System.out.println("7. 전화번호 변경");
			System.out.println("8. 주소 변경");
			System.out.println("9. 회원 탈퇴");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : memberController.createNewMember(inputMember()); break;
				case 2 : memberController.selectAllMembers(); break;
				case 3 : memberController.searchMemberById(inputMemberId()); break;
				case 4 : memberController.searchMemberByGender(inputGender()); break;
				case 5 : memberController.modifyPassword(inputMemberId(), inputPassword()); break;
				case 6 : memberController.modifyEmail(inputMemberId(), inputEmail()); break;
				case 7 : memberController.modifyPhone(inputMemberId(), inputPhone()); break;
				case 8 : memberController.modifyAddress(inputMemberId(), inputAddress()); break;
				case 9 : memberController.deleteMember(inputMemberId()); break;
				case 0 : return;
				default : System.out.println("잘못된 번호입니다. 다시 입력해주세요. \n");
				
			}
			
		}while(true);
		
	}
	
	public String inputMemberId() {
		
		System.out.print("회원 아이디 : ");
		String MemberId = sc.nextLine();
		
		return sc.nextLine();
	}
	
	public Map<String, String> inputMember() {
		
		System.out.print("아이디 :");
		String memberId = sc.nextLine() + sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("나이 : ");
		String age = sc.nextLine();
	
		/* 회원에 대한 모든 정보를 문자열로만 입력하고, 입력한 정보를 HashMap에 반환해서 리턴 */
		Map<String, String> memberInfo = new HashMap<>();
		memberInfo.put("memberId", memberId);
		memberInfo.put("memberPwd", password);
		memberInfo.put("memberName", name);
		memberInfo.put("memberGender", gender);
		memberInfo.put("memberEmail", email);
		memberInfo.put("memberPhone", phone);
		memberInfo.put("memberAddress", address);
		memberInfo.put("memberAge", age);
		/* 여기서는 사용자의 입력을 받아 맵에 넣는 것을 하면 됩니다. */
		
		return memberInfo;
	}
	
	public String inputGender() {
		
		System.out.print("조회할 성별 입력(남:M/여:F) : ");
		sc.nextLine();
		return sc.nextLine().toUpperCase();
	}
	
	public String inputPassword() {
		
		System.out.print("수정할 비밀번호 입력 : ");
		return sc.nextLine();
	}
	
	public String inputEmail() {
		
		System.out.print("수정할 이메일 입력 : ");
		return sc.nextLine();
	}
	
	public String inputPhone() {
		
		System.out.print("수정할 전화번호 입력 : ");
		return sc.nextLine();
	}
	
	public String inputAddress() {
		
		System.out.print("수정할 주소 입력 : ");
		return sc.nextLine();
		
		
	}
	
}






















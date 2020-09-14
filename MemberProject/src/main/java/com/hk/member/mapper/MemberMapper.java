package com.hk.member.mapper;

import java.util.List;

import com.hk.member.vo.Member;

public interface MemberMapper {

	
	//CRUD (Create/ Read or Retrieve/ Update / Delete)
	//1.전체 리스트
	//@Select("select * from members")
	
	public List<Member> memberList();
	//2.한개만 보기
	//3.한개만 insert하기
	//4.수정
	//5.삭제
	
	public int memberRegister(Member member);
	
	public Member memberGetOne(int mno);
	
	public int memberUpdate(Member member);
	
	public int memberDelete(int mno);
	
	public Member memberLogin(Member member);
}

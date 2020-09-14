package com.hk.member.vo;

import java.util.Date;

import lombok.Data;


@Data
public class Member {
	int mno;
	String email;
	String pwd;
	String mname;
	Date cre_date;
	Date mod_date;



	//3가지를 기본 생성해야함.
	//1.getter
	//2.setter
	//3.toString



}

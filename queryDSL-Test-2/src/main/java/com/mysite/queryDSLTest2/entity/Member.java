package com.mysite.queryDSLTest2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
	
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    private String addr;
    
    // Q클래스 생성 => MemberRepository 인터페이스 생성
    //	=> MemberRepositoryCustom 인터페이스 생성 => MemberRepositoryCustomImpl 클래스 생성
    //		List<Member> getMemberList(MemberDTO memberDTO);
    //	MemberRepositoryCustomImpl에서 메소드 오버라이딩을 통한 QueryDSL 생성
    	// where name like %?%
    	// where email like %?%
    	// where addr like %?%
}

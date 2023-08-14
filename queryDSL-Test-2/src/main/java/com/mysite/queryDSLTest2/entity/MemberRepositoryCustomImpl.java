package com.mysite.queryDSLTest2.entity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

	//QueryDSL 구현 
	
	private JPAQueryFactory jpaQueryFactory; 
	
	public MemberRepositoryCustomImpl (EntityManager em) {
		this.jpaQueryFactory = new JPAQueryFactory(em); 
	}
	
	
	private BooleanExpression searchName (String name ) {
		
		return StringUtils.isEmpty(name) ? null : QMember.member.name.like(name) ; 	 
		 
	}
	
	private BooleanExpression searchEmail(String email) {
		
		return StringUtils.isEmpty(email) ? null : QMember.member.email.like(email); 
	}
	
	private BooleanExpression searchAddr(String addr) {
		return StringUtils.isEmpty(addr) ? null : QMember.member.addr.like(addr); 
	}
	
	@Override
	public List<Member> getAdminMemberPage(MemberSearchDto memberSearchDto) {
		
		List<Member> memberList = jpaQueryFactory
				.selectFrom(QMember.member)
				.where(searchName(memberSearchDto.getSearchName(), 
						searchEmail(memberSearchDto.getSearchEmail(), 
						searchAddr(memberSearchDto.getSearchAddr() )
				.

				
				
				
				
		
		

		
		
		return null;
	}
	

}

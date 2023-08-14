package com.mysite.queryDSLTest2.entity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MemberRepositoryCustom {

    List<Member> getAdminMemberPage(MemberSearchDto memberSearchDto);

}

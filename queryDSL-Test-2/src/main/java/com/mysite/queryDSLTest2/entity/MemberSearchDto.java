package com.mysite.queryDSLTest2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSearchDto {
    private String searchName;		// 회원/관리자별 , 날짜별로 검색 

    private String searchEmail;

    private String searchAddr;   // main에서 검색어가 주입, 관리자 페이지에서도 사용 

}

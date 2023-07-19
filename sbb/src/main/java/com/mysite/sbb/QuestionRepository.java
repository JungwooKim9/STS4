package com.mysite.sbb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
		// QuestionRepository: Question 테이블을 CRUD 하는 메소드 구현

	// client =====> Controller =====> Service =====> Repository =====> Entity =====> DB
								// (비즈니스 로직 처리)	(DAO, DB를 직접 접근)
	
	// Repository: 메소드를 사용해서 DB의 테이블을 select, insert, update, delete
		// JpaRepository <Question, Integer> 인터페이스를 구현해서 생성해야 한다.
			// Question: Entity class
			// Integer: Question Entity 클래스의 Primary Key 컬럼의 DataType
	
	// JPA 메소드
		// findAll(): select
		// save()	: insert, update
		// delete()	: delete
	
	// JPA 메소드를 사용한 테이블 검색: 기본적으로 2개의 메소드는 자동으로 등록되어 있음
			// 그외는 등록해서 사용해야 한다.
		// findAll(): select * from question	<== 모든 레코드를 출력
		// findById(1): select * from question where id = 1	<== id를 기준으로 레코드 1개 출력
	
	// 검색된 레코드가 1개일 때는 Optional에 저장
	// 검색된 레코드가 여러개일 때는 List에 저장
	// Select * from question where subject = ''
	List <Question> findBySubject(String subject);
	
	// Select * from question where content = ''
	List<Question> findByContent(String content);
	
	// 특정 컬럼의 값을 검색: like 검색	<== 레코드가 여러개 검색: List
	// Select * from question where subject like '%?%';
	List<Question> findBySubjectLike(String subject);
	
	// Select * from question where content like '%?%';
	List<Question> findByContentLike(String content);

	// 제목과 내용 컬럼에서 검색
	// select * from question where subject like '%?%' or content like '%?%'
	List<Question> findBySubjectLikeOrContentLike(String subject, String content);
	
	// 정렬해서 출력하는 메소드 생성	<== 간단하고 자주 사용하는 것, 복잡한 쿼리: JPQL, QueryDSL
	// 날짜를 기준으로 오름차순 정렬 (Asc): 1 --> 9, A --> Z, ㄱ --> ㅎ
	// 날짜를 기준으로 내림차순 정렬 (Desc): 9 --> 1, Z --> A, ㅎ --> ㄱ
	
	// select * from question order by create_date asc;
	List<Question> findAllByOrderByCreateDateAsc();
	// select * from question order by create_date desc;
	List<Question> findAllByOrderByCreateDateDesc();
	
	// 제목을 기준으로 검색 후 날짜를 기준으로 오름차순 정렬 후 출력
	// select * from question where subject Like '%?%' order by create_date asc;
	List<Question> findBySubjectLikeOrderByCreateDateAsc(String subject);
	
	// select * from question where subject Like '%?%' order by create_date desc;
	List<Question> findBySubjectLikeOrderByCreateDateDesc(String subject);
	
	// 검색 기능을 사용(select, find)
	
	// save(): insert, update
	
	// delete(): delete
}

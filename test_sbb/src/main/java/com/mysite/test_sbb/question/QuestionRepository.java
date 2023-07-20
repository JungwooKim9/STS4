package com.mysite.test_sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	// 검색된 레코드가 1개일 때는 Optional에 저장
		// 검색된 레코드가 여러개일 때는 List에 저장
		// Select * from question where subject = ''
		List <Question> findBySubject(String subject);
		
		// Select * from question where content = ''
		List<Question> findByContent(String content);
		
		// Select * from question where subject like '%?%';
		List<Question> findBySubjectLike(String subject);
		
		// Select * from question where content like '%?%';
		List<Question> findByContentLike(String content);

		// 제목과 내용 컬럼에서 검색
		// select * from question where subject like '%?%' or content like '%?%'
		List<Question> findBySubjectLikeOrContentLike(String subject, String content);

		// 제목을 기준으로 검색 후 날짜를 기준으로 오름차순 정렬 후 출력
		// select * from question where subject Like '%?%' order by create_date asc;
		List<Question> findBySubjectLikeOrderByCreateDateAsc(String subject);
		
		// select * from question where subject Like '%?%' order by create_date desc;
		List<Question> findBySubjectLikeOrderByCreateDateDesc(String subject);
		
		// 검색 기능을 사용(select, find)
		
		// save(): insert, update
		
		// delete(): delete
	
}

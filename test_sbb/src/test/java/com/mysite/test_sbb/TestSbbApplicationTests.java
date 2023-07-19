package com.mysite.test_sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSbbApplicationTests {

	// QuestionRepository 객체 주입
	@Autowired
	private QuestionRepository qr;

//	@Test
	void contextLoads() {
		Question q1 = new Question();

		q1.setSubject("서울 맛집은?");
		q1.setContent("서울 맛집이 궁금합니다.");
		q1.setCreateDate(LocalDateTime.now());

		qr.save(q1);

		Question q2 = new Question();

		q2.setSubject("네이버 인기 웹툰 1위는?");
		q2.setContent("네이버 인기 웹툰 1위가 궁금합니다.");
		q2.setCreateDate(LocalDateTime.now());

		qr.save(q2);
	}
	
//	@Test
	void subjectTest() {
		List<Question> all = qr.findAll();
		
		Question q = all.get(0);
		
		assertEquals("서울 맛집은?", q.getSubject());
		
	}
	
//	@Test
	void searchSubjectLike() {
		List<Question> all = qr.findBySubjectLike("%맛집%");
		
		Question q = all.get(0);
		
		assertEquals(1, all.size());
		assertEquals(1, q.getId());
	}
	
	@Test
	void searchContentLike() {
		List <Question> all = qr.findByContentLike("%인기%");
		
		Question q = all.get(0);
		
		assertEquals(1, all.size());
		assertEquals(2, q.getId());
	}

}

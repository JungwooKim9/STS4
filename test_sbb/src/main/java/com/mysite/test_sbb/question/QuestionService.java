package com.mysite.test_sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.test_sbb.DataNotFoundException;
import com.mysite.test_sbb.question.Question;
import com.mysite.test_sbb.question.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	// Question 테이블의 모든 레코드를 읽어와서 List<Question>으로 값을 리턴하는 메소드
	public List<Question> getList() {
		
		return questionRepository.findAll();
	}
	
	// 글 상세 페이지
	public Question getQuestion(Integer id) {
		
		Optional<Question> question = questionRepository.findById(id);
		
		if(question.isPresent()) {
			return question.get();
			
		}else {
			throw new DataNotFoundException("question not found");
			
		}
		
	}
	
}

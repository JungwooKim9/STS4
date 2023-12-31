package com.mysite.test_sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.test_sbb.answer.AnswerService;
import com.mysite.test_sbb.question.Question;
import com.mysite.test_sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final AnswerService answerService;
	private final QuestionService questionService;
	
	@PostMapping("/create/{id}")	//	/answer/create/{id}
	public String createAnswer(Model model, @PathVariable Integer id,
			@RequestParam String content) {
		
		// id 변수가 잘 넘어오는지 출력
//		System.out.println("=====id: " + id + " =====");
//		System.out.println("=====content: " + content + "=====");
//		System.out.println("=====abc: " + abc + " =====");
		
		// 1. 변수: id의 값으로 Question 객체를 받아와야 함.
		Question question = questionService.getQuestion(id);
		
		// 2. Service에서 변수 2개를 넣어서 값을 Insert
		answerService.create(question, content);
		
		// question_detail로 리턴: get 방식으로 URL로 redirect
		return String.format("redirect:/question/detail/%s", id);
	}
	
}

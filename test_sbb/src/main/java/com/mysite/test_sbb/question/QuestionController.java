package com.mysite.test_sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;

// client의 /question/list 요청을 처리하는 메소드: http://localhost:9898/question/list
	@GetMapping("/question/list")
	public String list(Model model) {
		// 1. client 요청을 받는다. http://localhost:9898/question/list

		// 2. 비즈니스 로직 처리
		List<Question> questionList = questionService.getList();

		// 3. 받아온 List를 client로 전송 (Model 객체에 저장해서 Client로 전송)
		model.addAttribute("questionList", questionList);

		return "question_list";
	}

	@GetMapping("/question/detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		Question question = questionService.getQuestion(id);
		/*
		 * 잘 출력되는지 확인 후 제거 System.out.println("=== Question 객체 출력 ===");
		 * System.out.println(question.getId());
		 * System.out.println(question.getSubject());
		 * System.out.println(question.getContent());
		 */

		// 3. 모델 객체에 백엔드의 값을 담아서 뷰 페이지로 전송
		model.addAttribute("question", question);

		return "question_detail";
	}

}

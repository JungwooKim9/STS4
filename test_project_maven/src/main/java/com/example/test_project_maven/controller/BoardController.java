package com.example.test_project_maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	
	// 게시판을 Read
	// http://localhost:9595/read
	@GetMapping("/read")
//	@ResponseBody
	public String readBoard() {
		// 1. 요청을 받아서
		
		// 2. BackEnd에 일을 처리: 백엔드에 비즈니스 로직 처리: service
		
		// 3. 응답 값을 받아오고, Model에 클라이언트에 넘길 값을 저장 후
		
		// 4. view 페이지로 리다이렉트
		
		return "readBoard";
	}

}

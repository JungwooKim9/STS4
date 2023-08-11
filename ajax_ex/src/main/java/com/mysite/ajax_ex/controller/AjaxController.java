package com.mysite.ajax_ex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.ajax_ex.dto.AjaxDTO;

@Controller
public class AjaxController {

	@GetMapping("/")
	public String indexView() {
		return "index";
	}
	
	@GetMapping("/ex01")	// http://localhost:9797/ex01
	public String Ex01View() {
		
		return "ajax-ex-01";
	}
	
	@GetMapping("/ajax/ex01")	// Ajax를 통한 비동기 통신
	public String Ex01Ajax() {
		
		return "index";			// index 페이지의 소스 정보가 클라이언트로 전송
	}
	
	@GetMapping("/ex02")	// http://localhost:9797/ex02
	public String Ex02View() {
		
		return "ajax-ex-02";
	}
	
	@GetMapping("/ajax/ex02")	// Ajax를 통한 비동기 통신
	public @ResponseBody String Ex02Ajax() {
		
		return "index";			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	@GetMapping("/ex03")	// http://localhost:9797/ex03
	public String Ex03View() {
		
		return "ajax-ex-03";
	}
	
	// client Ajax에서 변수값을 넘김 @RequestParam 어노테이션으로 값을 받기
	@GetMapping("/ajax/ex03")	// Ajax를 통한 비동기 통신
	public @ResponseBody String Ex03Ajax(
			@RequestParam String param1, String param2
			) {
		System.out.println("Ajax Controller: ex03 요청 성공");
		System.out.println("param1: " + param1);
		System.out.println("param1: " + param2);
		
		return "ex03 요청 처리 완료됨";			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	@GetMapping("/ex04")	// http://localhost:9797/ex04
	public String Ex04View() {
		
		return "ajax-ex-04";
	}
	
	// client Ajax에서 변수값을 넘김 @RequestParam 어노테이션으로 값을 받기
	@PostMapping("/ajax/ex04")	// Ajax를 통한 비동기 통신
	public @ResponseBody String Ex04Ajax(
			@RequestParam String param1, String param2
			) {
		System.out.println("Ajax Controller: ex04 요청 성공");
		System.out.println("param1: " + param1);
		System.out.println("param1: " + param2);
		
		return "ex04 요청 처리 완료됨";			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	@GetMapping("/ex05")	// http://localhost:9797/ex05
	public String Ex05View() {
		
		return "ajax-ex-05";
	}
	
	// client Ajax에서 변수값을 넘김 @RequestParam 어노테이션으로 값을 받기
	@GetMapping("/ajax/ex05")	// Ajax를 통한 비동기 통신
	public @ResponseBody String Ex05Ajax(
//			@ModelAttribute
			AjaxDTO ajaxDTO
			) {
		System.out.println("Ajax Controller: ex05 요청 성공");
		System.out.println("param1: " + ajaxDTO.getParam1());
		System.out.println("param1: " + ajaxDTO.getParam2());
		
		return "ex05 요청 처리 완료됨";			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	// @RequestParam: 변수 1개와 @ModelAttribute: dto에 한꺼번에 주입 생략 가능
	
	@GetMapping("/ex06")	// http://localhost:9797/ex06
	public String Ex06View() {
		
		return "ajax-ex-06";
	}
	
	@PostMapping("/ajax/ex06")	// Ajax를 통한 비동기 통신
	public @ResponseBody AjaxDTO Ex06Ajax(
//			@ModelAttribute
			AjaxDTO ajaxDTO
			) {
		System.out.println("Ajax Controller: ex06 요청 성공");
		System.out.println("param1: " + ajaxDTO.getParam1());
		System.out.println("param1: " + ajaxDTO.getParam2());
		System.out.println("ajaxDTO: " + ajaxDTO);
		
		
		return ajaxDTO;			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	@GetMapping("/ex07")	// http://localhost:9797/ex07
	public String Ex07View() {
		
		return "ajax-ex-07";
	}
	
	// @RequestBody : client (JSON) ===> JSON을 DTO(자바의 객체)로 주입
	@PostMapping("/ajax/ex07")	// Ajax를 통한 비동기 통신
	public @ResponseBody AjaxDTO Ex07Ajax(
			@RequestBody
			AjaxDTO ajaxDTO
			) {
		System.out.println("Ajax Controller: ex07 요청 성공");
		System.out.println("param1: " + ajaxDTO.getParam1());
		System.out.println("param1: " + ajaxDTO.getParam2());
		System.out.println("ajaxDTO: " + ajaxDTO);
		
		
		return ajaxDTO;			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	@GetMapping("/ex08")	// http://localhost:9797/ex08
	public String Ex08View() {
		
		return "ajax-ex-08";
	}
	
	// @RequestBody : client (JSON) ===> JSON을 DTO(자바의 객체)로 주입
	@PostMapping("/ajax/ex08")	// Ajax를 통한 비동기 통신
	public @ResponseBody List<AjaxDTO> Ex08Ajax(
			@RequestBody
			AjaxDTO ajaxDTO
			) {
		System.out.println("Ajax Controller: ex08 요청 성공");
		System.out.println("param1: " + ajaxDTO.getParam1());
		System.out.println("param1: " + ajaxDTO.getParam2());
		System.out.println("ajaxDTO: " + ajaxDTO);
		
		List<AjaxDTO> dtoList = new ArrayList();
		
		dtoList.add(ajaxDTO);	// client의 넘어오는 dto를 그대로 List에 추가
		
		AjaxDTO ajaxDTO1 = new AjaxDTO();
		
		ajaxDTO1.setParam1("홍길동");
		ajaxDTO1.setParam2("남자");
		
		dtoList.add(ajaxDTO1);
		
		AjaxDTO ajaxDTO2 = new AjaxDTO();
		
		ajaxDTO2.setParam1("신사임당");
		ajaxDTO2.setParam2("여자");
		
		dtoList.add(ajaxDTO2);
		
		
		return dtoList;			// @ResponseBody: 리턴 타입 앞에 할당, JSON 포멧으로 변환 후 전송
	}
	
	@GetMapping("/ex09")	// http://localhost:9797/ex09
	public String Ex09View() {
		
		return "ajax-ex-09";
	}
	
	// ResponseEntity: JSON 타입으로 <객체, List>, <http 상태코드>
	
	@PostMapping("/ajax/ex09")	// Ajax를 통한 비동기 통신
	public ResponseEntity Ex09Ajax(
			@RequestBody
			AjaxDTO ajaxDTO
			) {
		System.out.println("Ajax Controller: ex09 요청 성공");
		System.out.println("param1: " + ajaxDTO.getParam1());
		System.out.println("param1: " + ajaxDTO.getParam2());
		System.out.println("ajaxDTO: " + ajaxDTO);
		
		
		return new ResponseEntity<>(ajaxDTO, HttpStatus.OK);
	}
	
	@GetMapping("/ex10")	// http://localhost:9797/ex10
	public String Ex10View() {
		
		return "ajax-ex-10";
	}
	
	@PostMapping("/ajax/ex10")	// Ajax를 통한 비동기 통신
	public ResponseEntity Ex10Ajax(
			@RequestBody
			AjaxDTO ajaxDTO
			) {
		System.out.println("Ajax Controller: ex08 요청 성공");
		System.out.println("param1: " + ajaxDTO.getParam1());
		System.out.println("param1: " + ajaxDTO.getParam2());
		System.out.println("ajaxDTO: " + ajaxDTO);
		
		List<AjaxDTO> dtoList = new ArrayList();
		
		dtoList.add(ajaxDTO);	// client의 넘어오는 dto를 그대로 List에 추가
		
		AjaxDTO ajaxDTO1 = new AjaxDTO();
		
		ajaxDTO1.setParam1("홍길동");
		ajaxDTO1.setParam2("남자");
		
		dtoList.add(ajaxDTO1);
		
		AjaxDTO ajaxDTO2 = new AjaxDTO();
		
		ajaxDTO2.setParam1("신사임당");
		ajaxDTO2.setParam2("여자");
		
		dtoList.add(ajaxDTO2);
		
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
}

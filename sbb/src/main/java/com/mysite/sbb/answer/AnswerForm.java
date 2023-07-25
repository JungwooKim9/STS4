package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

	@NotEmpty(message="답변은 비어있으면 안됩니다. 답변을 넣어주세요")
	private String content;
	
	
}

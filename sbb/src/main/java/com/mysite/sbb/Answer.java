package com.mysite.sbb;

import java.time.LocalDateTime;		// 그 지역에 맞도록 날짜와 시간을 등록

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Answer {
		// 답변 글을 저장하는 테이블: 자식 테이블

	// 주의: Entity 클래스에는 @Getter / @Setter 를 붙이지 않는다. DTO 생성 후 붙인다.
		// 편의상
	
	// @Entity: java의 클래스를 DB의 테이블로 맵핑
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "text")
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;	// 2003-07-18
		// JPA에서 필드 이름을: crateDate <=====> CREATE_DATE(DB에 이렇게 들어감)
	
	// Foreign Key;
		// question <=====> QUESTION_ID
	@ManyToOne			// 답변(Answer): Many =======>질문(Question): one
	private Question question;
	
}

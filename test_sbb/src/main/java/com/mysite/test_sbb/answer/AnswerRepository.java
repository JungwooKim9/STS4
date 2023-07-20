package com.mysite.test_sbb.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysite.test_sbb.answer.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}

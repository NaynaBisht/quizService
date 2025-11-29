package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Question;
import com.quiz.model.QuestionWrapper;
import com.quiz.model.Response;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
		return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable String id) {
		return quizService.getQuizquestions(id);
	}

	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable String id, @RequestBody List<Response> responses) {
		return quizService.calculateResult(id, responses);
	}

}

package com.quiz.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quiz.model.Quiz;

public interface QuizDao extends MongoRepository<Quiz, String> {

}

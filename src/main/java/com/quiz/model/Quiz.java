package com.quiz.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
@Data
public class Quiz {

	@Id
	private String id;
	private String title;

	private List<Integer> questionIds;
}

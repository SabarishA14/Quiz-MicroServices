package com.sab.quizservice.Model;


import lombok.Data;

@Data
public class QuizDTO {

    private String categoryName;
    private int numOfQuestion;
    private String title;
}

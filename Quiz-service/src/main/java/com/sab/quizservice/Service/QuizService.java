package com.sab.quizservice.Service;



import com.sab.quizservice.Feign.QuizInterface;
import com.sab.quizservice.Model.QuestionWrapper;
import com.sab.quizservice.Model.Quiz;
import com.sab.quizservice.Model.Response;
import com.sab.quizservice.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizInterface quizInterface;

    @Autowired
    QuizRepo quizRepo;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();

        System.out.println("Category: " + category);
        System.out.println("Requested number: " + numQ);
        System.out.println("Received question IDs: " + questions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepo.save(quiz);


        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionsIds();


        ResponseEntity<List<QuestionWrapper>> question = quizInterface.getQuestionFromId(questionIds);


        return question;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}

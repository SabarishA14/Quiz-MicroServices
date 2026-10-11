package com.sab.questionservice.Controller;



import com.sab.questionservice.Model.Question;
import com.sab.questionservice.Model.QuestionWrapper;
import com.sab.questionservice.Model.Response;
import com.sab.questionservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);

    }

    @GetMapping("Generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName,@RequestParam int numOfQuestions){

        return questionService.getQuestionForQuiz(categoryName,numOfQuestions);
    }

    @PostMapping("getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> quizIds){

        System.out.println("Received question IDs: " + quizIds);

        ResponseEntity<List<QuestionWrapper>> response =
                questionService.getQuestionFromId(quizIds);

        System.out.println("Returning questions: " + response.getBody());

        return response;
        //return questionService.getQuestionFromId(quizIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }


}

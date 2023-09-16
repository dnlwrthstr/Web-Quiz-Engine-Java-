package engine.mapper;

import engine.domain.Quiz;
import engine.dto.CreateQuizDto;
import engine.dto.QuizDto;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {

    public Quiz map(CreateQuizDto createQuizDto, int quizId, String userName) {
        // Add validation or error handling for createQuizDto.getOptions() and createQuizDto.getAnswer()
        Quiz quiz = new Quiz(createQuizDto.getTitle(),
                createQuizDto.getText(),
                createQuizDto.getOptions(),
                createQuizDto.getAnswer(),
                userName
                );
        quiz.setId(quizId);
        return quiz;
    }

    public QuizDto map(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        quizDto.setText(quiz.getText());
        quizDto.setOptions(quiz.getOptions());
        return quizDto;
    }
}


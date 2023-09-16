package engine.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuizCompletionDto {
    private long id;

    private LocalDateTime completedAt;

}


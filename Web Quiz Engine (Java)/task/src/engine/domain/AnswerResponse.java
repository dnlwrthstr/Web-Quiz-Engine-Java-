package engine.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerResponse {
    private boolean success;
    private String feedback;

    public AnswerResponse(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }
}

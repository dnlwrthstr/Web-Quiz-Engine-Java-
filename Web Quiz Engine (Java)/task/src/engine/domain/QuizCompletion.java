package engine.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
public class QuizCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Quiz quiz;

    private LocalDateTime completedAt;

    private String completedBy;
}
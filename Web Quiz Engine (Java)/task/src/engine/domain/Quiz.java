package engine.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String text;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> options;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Integer> answer;

    private String author;

    public Quiz(String title, String text, List<String> options, List<Integer> answer, String author) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.author = author;
    }

}

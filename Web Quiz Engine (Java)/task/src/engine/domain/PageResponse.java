package engine.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageResponse<T> {

    private int totalPages;
    private long totalElements;
    private boolean last;
    private boolean first;
    private int number;
    private int numberOfElements;
    private int size;
    private boolean empty;
    private List<T> content;

    public PageResponse(
            int totalPages,
            long totalElements,
            boolean last,
            boolean first,
            int number, int numberOfElements, int size, boolean empty,
            List<T> content
    ) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.last = last;
        this.first = first;
        this.number = this.number;
        this.numberOfElements = this.numberOfElements;
        this.size = this.size;
        this.empty = empty;
        this.content = content;
    }

    // getters for all fields
}

package engine.dto;

import engine.domain.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {

        private int totalPages;
        private long totalElements;
        private boolean last;
        private boolean first;
        private int number;
        private int numberOfElements;
        private int size;
        private boolean empty;
        private List<T> content;

}

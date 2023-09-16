package engine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import engine.domain.QuizCompletion;

public interface QuizCompletionRepository extends PagingAndSortingRepository<QuizCompletion, Long> {
    Page<QuizCompletion> findByCompletedByOrderByCompletedAtDesc(String username, Pageable pageable);

    void deleteByQuizId(long id);
}

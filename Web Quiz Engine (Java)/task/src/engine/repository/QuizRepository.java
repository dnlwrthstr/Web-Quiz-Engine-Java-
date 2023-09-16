package engine.repository;

import engine.domain.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Long> {
    Page<Quiz> findAll(Pageable pageable);
    Optional<Quiz> getById(long id);
}

package engine.serive;

import engine.domain.QuizCompletion;
import engine.repository.QuizCompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CompletionService {
    @Autowired
    private QuizCompletionRepository completionRepository;

    public Page<QuizCompletion> getCompletedQuizzesByUser(UserDetails userDetails, Pageable pageable) {
        return completionRepository.findByCompletedByOrderByCompletedAtDesc(userDetails.getUsername(), pageable);
    }
}


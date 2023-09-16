package engine.controller;


import engine.domain.QuizCompletion;
import engine.dto.PageResponseDto;
import engine.dto.QuizCompletionDto;
import engine.serive.CompletionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes/completed")
public class CompletionController {

    private final CompletionService completionService;

    public CompletionController(CompletionService completionService) {
        this.completionService = completionService;
    }

    @GetMapping
    public PageResponseDto<QuizCompletionDto> getCompletedQuizzes(
            @RequestParam(defaultValue = "0") int page,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        Page<QuizCompletion> completions = completionService.getCompletedQuizzesByUser(userDetails, PageRequest.of(page, 10));

        List<QuizCompletionDto> completionDtoList = completions.getContent().stream()
                .map(this::convertToDto)
                .toList();


        return new PageResponseDto<>(
                completions.getTotalPages(),
                completions.getTotalElements(),
                completions.isLast(),
                completions.isFirst(),
                completions.getNumber(),
                completions.getNumberOfElements(),
                completions.getSize(),
                completions.isEmpty(),
                completionDtoList
        );
    }

    private QuizCompletionDto convertToDto(QuizCompletion completion) {
        QuizCompletionDto dto = new QuizCompletionDto();
        dto.setId(completion.getQuiz().getId());
        dto.setCompletedAt(completion.getCompletedAt());
        return dto;
    }
}
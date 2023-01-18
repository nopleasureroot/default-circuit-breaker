package com.lessons.client.service;

import com.lessons.client.exception.BadRequestException;
import com.lessons.client.model.LessonDTO;
import com.lessons.client.model.LessonList;
import com.lessons.client.util.Constants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LessonsService.class);
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    private Resilience4JCircuitBreaker circuitBreaker;
    private final RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void initCircuitBreaker() {
        circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
    }
    public List<LessonDTO> getLessons() {
        return circuitBreaker.run(
                () -> restTemplate.getForObject(Constants.TEST_SERVICE_URL, LessonList.class),
                throwable -> {
                    LOGGER.error(String.format("Sending request ended with an error: %s", throwable.getMessage()));
                    throw new BadRequestException(String.format(Constants.GENERAL_ERROR, throwable.getMessage()));
                }
        ).lessonDTOList();
    }
}

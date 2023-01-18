package com.lessons.client.controller;

import com.lessons.client.model.LessonDTO;
import com.lessons.client.service.LessonsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@AllArgsConstructor
public class LessonsController {
    private LessonsService lessonsService;

    @GetMapping
    public ResponseEntity<List<LessonDTO>> getLessons() {
        return ResponseEntity.ok(lessonsService.getLessons());
    }
}

package com.lessons.lessonsservice.controller;

import com.lessons.lessonsservice.model.LessonList;
import com.lessons.lessonsservice.service.LessonsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
@AllArgsConstructor
public class LessonsController {
    private LessonsService lessonsService;

    @GetMapping
    public ResponseEntity<LessonList> getLessons() {
        return ResponseEntity.ok(lessonsService.getLessons());
    }

    @PostMapping("/downtime")
    @ResponseStatus(HttpStatus.OK)
    public void changeSleepTime(@RequestBody long downtime) {
        lessonsService.setDowntime(downtime);
    }
}

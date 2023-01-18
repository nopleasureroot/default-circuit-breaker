package com.lessons.lessonsservice.model;

import lombok.Builder;

import java.util.List;

public record LessonList(List<LessonDTO> lessonDTOList) {
    @Builder
    public LessonList {
    }
}

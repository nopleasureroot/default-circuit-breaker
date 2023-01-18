package com.lessons.client.model;

import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDate;

public record LessonDTO(
        @NonNull String name,
        @NonNull String teacherName,
        @NonNull LocalDate date
) {
    @Builder
    public LessonDTO {
    }
}

package com.lessons.lessonsservice.service;

import com.lessons.lessonsservice.exception.BadRequestException;
import com.lessons.lessonsservice.model.LessonDTO;
import com.lessons.lessonsservice.model.LessonList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LessonsService {
    private long downtime = 0;
    private static final Logger LOGGER = LoggerFactory.getLogger(LessonsService.class);
    public LessonList getLessons() {
        try {
            Thread.sleep(downtime);

            return LessonList.builder().lessonDTOList(
                    List.of(
                            LessonDTO.builder()
                                    .name("Physic")
                                    .teacherName("Gerasimov Nikolay Victorovich")
                                    .date(LocalDate.now().minusDays(2))
                                    .build(),
                            LessonDTO.builder()
                                    .name("Math")
                                    .teacherName("Biryukov Oleg Nikolaevich")
                                    .date(LocalDate.now().minusDays(5))
                                    .build(),
                            LessonDTO.builder()
                                    .name("Micro-electonic")
                                    .teacherName("UndefinedName")
                                    .date(LocalDate.now().plusDays(4))
                                    .build()
                    )
            ).build();
        } catch (InterruptedException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    public void setDowntime(long downtime) {
        LOGGER.info(String.format("Downtime has been set %s", downtime));

        this.downtime = downtime;
    }
}

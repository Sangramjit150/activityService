package com.fitness.activityService.dto;

import com.fitness.activityService.models.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ActivityRequest {
    private Long userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;

}

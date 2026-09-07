package com.fitness.activityService.Service;

import com.fitness.activityService.Repository.ActivityRepository;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.models.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        Activity activity=new Activity();
        activity.setUserid(activityRequest.getUserId());
        activity.setCaloriesBurned(activityRequest.getCaloriesBurned());
        activity.setDuration(activityRequest.getDuration());
        activity.setStartTime(activityRequest.getStartTime());
        activity.setType(activityRequest.getActivityType());


        Activity savedActivity=activityRepository.save(activity);

        ActivityResponse activityResponse=new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserid(savedActivity.getUserid());
        activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        activityResponse.setType(savedActivity.getType());
        return activityResponse;
    }
}

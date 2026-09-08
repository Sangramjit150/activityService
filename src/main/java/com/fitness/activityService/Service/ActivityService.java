package com.fitness.activityService.Service;

import com.fitness.activityService.Repository.ActivityRepository;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.models.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        activity.setMetrics(activityRequest.getAdditionalMetrics());

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
        activityResponse.setAdditionalMetrics(savedActivity.getMetrics());
        return activityResponse;
    }


    public List<ActivityResponse> getActivitiesByUserId(Long id) {
        List<Activity>activities=activityRepository.findByUserid(id);

        return activities.stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse activityResponse=new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserid(savedActivity.getUserid());
        activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        activityResponse.setType(savedActivity.getType());
        activityResponse.setAdditionalMetrics(savedActivity.getMetrics());
        return activityResponse;
    }

    public ActivityResponse getActivityById(Long id) {
        return activityRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(()->new RuntimeException("Activity not found"));
    }
}

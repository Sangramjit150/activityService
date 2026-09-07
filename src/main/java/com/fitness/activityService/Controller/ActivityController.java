package com.fitness.activityService.Controller;

import com.fitness.activityService.Service.ActivityService;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.models.Activity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {

    private ActivityService activityService;

    @PostMapping("/track")
    public ResponseEntity<ActivityResponse>trackActivity(@RequestBody ActivityRequest activityRequest){
        return ResponseEntity.ok(activityService.trackActivity(activityRequest));
    }

    @GetMapping("/getActivities/{id}")
    public ResponseEntity<List<ActivityResponse>>getActivitiesByUserId(@PathVariable Long id){
        return ResponseEntity.ok(activityService.getActivitiesByUserId(id));
    }
}

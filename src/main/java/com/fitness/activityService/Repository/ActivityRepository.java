package com.fitness.activityService.Repository;

import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByUserid(Long userid);

}

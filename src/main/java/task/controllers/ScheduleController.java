package task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import task.entities.Schedule;
import task.services.ScheduleService;

@RestController
public class ScheduleController {
	
	@Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PostMapping("/schedule/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.addSchedule(schedule);
    }

    @DeleteMapping("/schedule/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
    }

    @PutMapping("/schedule/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSchedule(@PathVariable int id, @RequestBody Schedule newSchedule) {
        scheduleService.updateSchedule(id, newSchedule);
    }
}

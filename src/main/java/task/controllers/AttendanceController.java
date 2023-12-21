package task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import task.entities.Attendance;
import task.services.AttendanceService;

@RestController
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;

	@GetMapping("/attendance")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAttendance();
    }

    @PostMapping("/attendance/add")
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return attendanceService.addAttendance(attendance);
    }

    @DeleteMapping("/attendance/delete/{attendanceId}")
    public void deleteAttendance(@PathVariable int attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
    }

    @PutMapping("/attendance/update/{attendanceId}")
    public void updateAttendance(@PathVariable int attendanceId, @RequestBody Attendance newAttendance) {
        attendanceService.updateAttendance(attendanceId, newAttendance);
    }
		
	
}


package task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import task.entities.Trainee;
import task.services.TraineeService;

@RestController
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping("/getAllTrainees")
    public List<Trainee> getAllTrainees() {
        return traineeService.getAllTrainees();
    }

    @PostMapping("/trainee/add")
    public Trainee addTrainee(@RequestBody Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }

    @DeleteMapping("/trainee/delete/{traineeId}")
    public void deleteTrainee(@PathVariable Integer traineeId) {
        traineeService.deleteTrainee(traineeId);
    }

    @PutMapping("/trainee/update/{traineeId}")
    public void updateTrainee(@PathVariable int traineeId, @RequestBody Trainee updatedTrainee) {
        traineeService.updateTrainee(traineeId, updatedTrainee);
    }
	
	@GetMapping("/getDetails/{courseId}")
	public List<Trainee> getAllDetails(@PathVariable int courseId) {
        return traineeService.getDetails(courseId);
    }
	
	@GetMapping("/getTrainerAndCourseDetails/{courseId}")
	public List<Object[]> getTraineeDetails(@PathVariable int courseId){
		return traineeService.getAllTraineeDetails(courseId);
	}
	
	@GetMapping("/getTrainerAndCourseAndTimeDetails/{courseId}")
	public List<Object[]> getTraineeAndScheduleController(@PathVariable int courseId){
		return traineeService.getAllTrainerAndCourseAndTimeDetails(courseId);
	}
}

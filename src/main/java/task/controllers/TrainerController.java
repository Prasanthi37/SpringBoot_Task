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

import task.entities.Trainer;
import task.services.TrainerService;

@RestController
public class TrainerController {
	@Autowired
    private TrainerService trainerService;

    @GetMapping("/getAllTrainers")
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @PostMapping("/trainer/add")
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @DeleteMapping("/trainer/delete/{trainerId}")
    public void deleteTrainer(@PathVariable Integer trainerId) {
        trainerService.deleteTrainer(trainerId);
    }

    @PutMapping("/trainer/update/{trainerId}")
    public void updateTrainer(@PathVariable int trainerId, @RequestBody Trainer updatedTrainer) {
        trainerService.updateTrainer(trainerId, updatedTrainer);
    }
}

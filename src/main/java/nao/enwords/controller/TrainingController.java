package nao.enwords.controller;

import nao.enwords.model.Training;
import nao.enwords.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class TrainingController {

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @RequestMapping(value = "/trainings", method = RequestMethod.GET, produces = "application/json")
    public List<Training> trainings() {
        return trainingRepository.findAll();
    }

    @RequestMapping(value = "/trainings", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Training create(@RequestBody Training training) {
        training.setTrainingDate(LocalDateTime.now());
        return trainingRepository.save(training);
    }

}

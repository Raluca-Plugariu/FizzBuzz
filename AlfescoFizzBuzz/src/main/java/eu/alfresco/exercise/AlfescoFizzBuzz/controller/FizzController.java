package eu.alfresco.exercise.AlfescoFizzBuzz.controller;

import eu.alfresco.exercise.AlfescoFizzBuzz.dto.FizzRange;
import eu.alfresco.exercise.AlfescoFizzBuzz.controller.exception.InvalidRangeException;
import eu.alfresco.exercise.AlfescoFizzBuzz.service.FizzBuzz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class FizzController {

    @Autowired
    private FizzBuzz fizzBuzz;

    @PostMapping(path="/start",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> get(@RequestBody FizzRange fizzRange) {
        int rMin;
        int rMax;
        try {
            rMin = Integer.valueOf(fizzRange.getMin());
            rMax = Integer.valueOf(fizzRange.getMax());

        } catch (NumberFormatException e) {
            throw new InvalidRangeException(e);
        }
        fizzBuzz.start(new FizzRange(rMin, rMax));

        return ResponseEntity.ok(fizzBuzz.getResultForStep2());
    }
}

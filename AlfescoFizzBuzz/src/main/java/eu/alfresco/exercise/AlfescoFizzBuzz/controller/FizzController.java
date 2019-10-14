package eu.alfresco.exercise.AlfescoFizzBuzz.controller;

import eu.alfresco.exercise.AlfescoFizzBuzz.FizzRange;
import eu.alfresco.exercise.AlfescoFizzBuzz.controller.exception.InvalidRangeException;
import eu.alfresco.exercise.AlfescoFizzBuzz.service.FizzBuzz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzController {

    @Autowired
    private FizzBuzz fizzBuzz;

    @GetMapping("/start")
    public String get(@RequestParam String rangeMin,@RequestParam String rangeMax){
        int rMin;
        int rMax;
        try {
             rMin= Integer.valueOf(rangeMin);
           rMax= Integer.valueOf(rangeMax);

        }catch (NumberFormatException e){
            throw new InvalidRangeException(e);
        }
        fizzBuzz.start(new FizzRange(rMin,rMax));

        return fizzBuzz.getResultForStep2();
    }
}

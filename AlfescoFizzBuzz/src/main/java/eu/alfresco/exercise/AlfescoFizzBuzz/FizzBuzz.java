package eu.alfresco.exercise.AlfescoFizzBuzz;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FizzBuzz {

    public String printResultForStepOne(FizzRange fizzRange){
       return IntStream.rangeClosed(fizzRange.getMin(),fizzRange.getMax())
                .mapToObj(this::compute)
                .collect(Collectors.joining(" "));
    }

    private String compute(@NonNull Integer x) {
        StringBuilder sb = new StringBuilder();

        if (x % 3 == 0) {
            sb.append("fizz");
        }
        if (x % 5 == 0) {
            sb.append("buzz");
        }

        if (sb.toString().equals("")) {
            sb.append(x.toString());
        }

        return sb.toString();
    }


}


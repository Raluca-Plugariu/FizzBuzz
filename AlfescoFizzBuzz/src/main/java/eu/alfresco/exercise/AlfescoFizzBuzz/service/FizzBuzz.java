package eu.alfresco.exercise.AlfescoFizzBuzz.service;

import eu.alfresco.exercise.AlfescoFizzBuzz.dto.FizzRange;
import eu.alfresco.exercise.AlfescoFizzBuzz.FizzReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FizzBuzz {

    @Autowired
    private FizzReport fizzReport;

    private String resultForStep2;

    public String getReport() {
        return fizzReport.getReport();
    }

    public String getResultForStep2() {
        return resultForStep2;
    }

    public void start(FizzRange fizzRange) {
        resultForStep2 = IntStream.rangeClosed(fizzRange.getMin(), fizzRange.getMax())
                .mapToObj(this::compute)
                .collect(Collectors.joining(" "));
    }

    private String compute(@NonNull Integer x) {

        if (x.toString().contains("3")) {
            fizzReport.addToReport(FizzReport.ALFRESCO);
            return FizzReport.ALFRESCO;
        }

        StringBuilder sb = new StringBuilder();
        if (x % 3 == 0) {
            sb.append(FizzReport.FIZZ);
        }
        if (x % 5 == 0) {
            sb.append(FizzReport.BUZZ);
        }

        if (("").equals(sb.toString())) {
            sb.append(x.toString());
        }

        fizzReport.addToReport(sb.toString());
        return sb.toString();
    }


}


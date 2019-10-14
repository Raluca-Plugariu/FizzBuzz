package eu.alfresco.exercise.AlfescoFizzBuzz;

        import org.springframework.stereotype.Component;

        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.stream.Collectors;

@Component
public class FizzReport {
    private Map<String, Integer> report;

    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String FIZZ_BUZZ = "fizzbuzz";
    public static final String ALFRESCO = "alfresco";
    public static final String INTEGER = "integer";


    public FizzReport() {
        report = new LinkedHashMap<>();
        report.put(FIZZ, 0);
        report.put(BUZZ, 0);
        report.put(FIZZ_BUZZ, 0);
        report.put(ALFRESCO, 0);
        report.put(INTEGER, 0);
    }

    public void addToReport(final String str) {
        Integer count;
        switch (str) {
            case FizzReport.ALFRESCO:
            case FizzReport.FIZZ:
            case FizzReport.FIZZ_BUZZ:
            case FizzReport.BUZZ:
                count = report.get(str);
                report.put(str, count + 1);
                break;
            default:
                count = report.get(FizzReport.INTEGER);
                report.put(FizzReport.INTEGER, count + 1);
        }

    }

    public String getReport(){
        return report.entrySet().stream()
                .map(this::getKeyValue)
                .collect(Collectors.joining(" "));
    }

    private String getKeyValue(Map.Entry<String,Integer> entry){
        return entry.getKey().toString() +": "+  entry.getValue().toString();
    }

}

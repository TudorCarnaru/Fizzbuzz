

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    private FizzBuzzOutput output = new FizzBuzzOutput();

    public FizzBuzzOutput doFizzBuzz(Integer lowerRange, Integer upperRange) {
        Map<String, Integer> mapFizzBuzz = new HashMap<>();
        List<String> fizzBuzzOutput = new ArrayList<>();
        for (int i = lowerRange; i<= upperRange; i++) {
            String fizzBuzzResult = checkFizzBuzz(i);
            if(isNumeric(fizzBuzzResult)) {
                Integer count = mapFizzBuzz.containsKey(FizzBuzzConstants.INTEGER_STRING) ? mapFizzBuzz.get(FizzBuzzConstants.INTEGER_STRING) : 0;
                mapFizzBuzz.put(FizzBuzzConstants.INTEGER_STRING, count + 1);
            } else {
                Integer count = mapFizzBuzz.containsKey(fizzBuzzResult) ? mapFizzBuzz.get(fizzBuzzResult) : 0;
                mapFizzBuzz.put(fizzBuzzResult, count + 1);
            }
            fizzBuzzOutput.add(fizzBuzzResult);
        }
        output.setOutputStatistics(mapFizzBuzz);
        output.setOutputString(fizzBuzzOutput);
        return output;
    }

    public String checkFizzBuzz(Integer numberToCheck) {
        if (checkContains(numberToCheck)) return FizzBuzzConstants.ALFRESCO_STRING;
        else if(numberToCheck % 3 == 0 && numberToCheck % 5 != 0) return FizzBuzzConstants.FIZZ_STRING;
        else if (numberToCheck % 5 == 0 && numberToCheck % 3 != 0) return FizzBuzzConstants.BUZZ_STRING;
        else if (numberToCheck % 15 == 0) return FizzBuzzConstants.FIZZ_BUZZ_STRING;
        else return numberToCheck.toString();
    }

    private boolean checkContains(Integer numberToContain) {
        while(numberToContain > 0) {
            if(numberToContain % 10 == 3){
                return true;
            }
            else {
                numberToContain = numberToContain /10;
            }
        }
        return false;
    }

    private boolean isNumeric(String stringToCheck) {
        for (char c: stringToCheck.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public FizzBuzzOutput getOutput() {
        return output;
    }

    public void setOutput(FizzBuzzOutput output) {
        this.output = output;
    }
}

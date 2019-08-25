package Application.Services;

import Application.EntitiesDto.FizzBuzzOutput;
import Application.UtilConstants.FizzBuzzConstants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FizzBuzzService {

    public FizzBuzzOutput doFizzBuzz(String lowerRangeInput, String upperRangeInput) throws Exception {
        FizzBuzzOutput output = new FizzBuzzOutput();
        Map<String, Integer> mapFizzBuzz = new HashMap<>();
        List<String> fizzBuzzOutput = new ArrayList<>();
        try {
            if(lowerRangeInput.equals("") || upperRangeInput.equals("")) {
                throw new Exception(FizzBuzzConstants.INVALID_RANGE_EXCEPTION);
            }
            Integer lowerRange = Integer.parseInt(lowerRangeInput);
            Integer upperRange = Integer.parseInt(upperRangeInput);
            if(lowerRange > upperRange || lowerRange < 0 || upperRange < 0) {
                throw new Exception(FizzBuzzConstants.INVALID_RANGE_EXCEPTION);
            }
            for (int i = lowerRange; i <= upperRange; i++) {
                String fizzBuzzResult = checkFizzBuzz(i);
                if (fizzBuzzResult.matches(FizzBuzzConstants.CHECK_NUMERICAL_REGEX)) {
                    Integer count = mapFizzBuzz.containsKey(FizzBuzzConstants.INTEGER_STRING) ? mapFizzBuzz.get(FizzBuzzConstants.INTEGER_STRING) : 0;
                    mapFizzBuzz.put(FizzBuzzConstants.INTEGER_STRING, count + 1);
                } else {
                    Integer count = mapFizzBuzz.containsKey(fizzBuzzResult) ? mapFizzBuzz.get(fizzBuzzResult) : 0;
                    mapFizzBuzz.put(fizzBuzzResult, count + 1);
                }
                fizzBuzzOutput.add(fizzBuzzResult);
            }
        } catch (Exception e) {
            if(e.getMessage().equals(FizzBuzzConstants.INVALID_RANGE_EXCEPTION)) {
                throw new Exception(e.getMessage());
            }
            else throw new Exception(FizzBuzzConstants.TEXT_IN_RANGE_EXCEPTION);
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
}

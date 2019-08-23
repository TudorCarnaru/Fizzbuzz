import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> doFizzBuzz(Integer lowerRange, Integer upperRange) {
        List<String> fizzBuzzOutput = new ArrayList<>();
        for (int i = lowerRange; i<= upperRange; i++) {
            String fizzBuzzResult = checkFizzBuzz(i);
            fizzBuzzOutput.add(fizzBuzzResult);
        }
        return fizzBuzzOutput;
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

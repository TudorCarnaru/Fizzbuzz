import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testDiv15() {
        assertEquals(fizzBuzz.checkFizzBuzz(15), FizzBuzzConstants.FIZZ_BUZZ_STRING);
    }

    @Test
    public void testDiv5() {
        assertEquals(fizzBuzz.checkFizzBuzz(5), FizzBuzzConstants.BUZZ_STRING);
    }

    @Test
    public void testDiv3() {
        assertEquals(fizzBuzz.checkFizzBuzz(6), FizzBuzzConstants.FIZZ_STRING);
    }

    @Test
    public void testAlfresco() {
        assertEquals(fizzBuzz.checkFizzBuzz(3), FizzBuzzConstants.ALFRESCO_STRING);
    }


    @Test
    public void testRangeAndReport() {
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).getOutputString().get(14), FizzBuzzConstants.FIZZ_BUZZ_STRING);
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).getOutputString().get(2), FizzBuzzConstants.ALFRESCO_STRING);
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).getOutputString().get(4), FizzBuzzConstants.BUZZ_STRING);
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).getOutputString().get(5), FizzBuzzConstants.FIZZ_STRING);

        assertEquals(fizzBuzz.getOutput().getOutputStatistics().get(FizzBuzzConstants.FIZZ_STRING), new Integer(4));
        assertEquals(fizzBuzz.getOutput().getOutputStatistics().get(FizzBuzzConstants.BUZZ_STRING), new Integer(3));
        assertEquals(fizzBuzz.getOutput().getOutputStatistics().get(FizzBuzzConstants.FIZZ_BUZZ_STRING), new Integer(1));
        assertEquals(fizzBuzz.getOutput().getOutputStatistics().get(FizzBuzzConstants.ALFRESCO_STRING), new Integer(2));
        assertEquals(fizzBuzz.getOutput().getOutputStatistics().get(FizzBuzzConstants.INTEGER_STRING), new Integer(10));
    }

}
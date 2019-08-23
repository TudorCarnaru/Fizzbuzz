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
    public void testRange() {
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).get(14), FizzBuzzConstants.FIZZ_BUZZ_STRING);
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).get(2), FizzBuzzConstants.ALFRESCO_STRING);
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).get(4), FizzBuzzConstants.BUZZ_STRING);
        assertEquals(fizzBuzz.doFizzBuzz(1, 20).get(5), FizzBuzzConstants.FIZZ_STRING);
    }

}
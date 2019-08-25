import Application.Services.FizzBuzzService;
import Application.UtilConstants.FizzBuzzConstants;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;


class FizzBuzzServiceTest {

    FizzBuzzService fizzBuzzService = new FizzBuzzService();

    private String lowerBound = "lowerBound";
    private String upperBound = "upperBound";
    private String localHost = "http://localhost:8181";


    private String badLowerRange= "-1";
    private String badUpperRangeInteger = "-20";
    private String badUpperRange = "badString";


    @Test
    public void testDiv15() {
        assertEquals(fizzBuzzService.checkFizzBuzz(15), FizzBuzzConstants.FIZZ_BUZZ_STRING);
    }

    @Test
    public void testDiv5() {
        assertEquals(fizzBuzzService.checkFizzBuzz(5), FizzBuzzConstants.BUZZ_STRING);
    }

    @Test
    public void testDiv3() {
        assertEquals(fizzBuzzService.checkFizzBuzz(6), FizzBuzzConstants.FIZZ_STRING);
    }

    @Test
    public void testAlfresco() {
        assertEquals(fizzBuzzService.checkFizzBuzz(3), FizzBuzzConstants.ALFRESCO_STRING);
    }


    @Test
    public void testRangeAndReport() throws Exception {

        String lowerRange = "1";
        String upperRange = "20";

        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputString().get(14), FizzBuzzConstants.FIZZ_BUZZ_STRING);
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputString().get(2), FizzBuzzConstants.ALFRESCO_STRING);
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputString().get(4), FizzBuzzConstants.BUZZ_STRING);
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputString().get(5), FizzBuzzConstants.FIZZ_STRING);

        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputStatistics().get(FizzBuzzConstants.FIZZ_STRING), new Integer(4));
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputStatistics().get(FizzBuzzConstants.BUZZ_STRING), new Integer(3));
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputStatistics().get(FizzBuzzConstants.FIZZ_BUZZ_STRING), new Integer(1));
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputStatistics().get(FizzBuzzConstants.ALFRESCO_STRING), new Integer(2));
        assertEquals(fizzBuzzService.doFizzBuzz(lowerRange, upperRange).getOutputStatistics().get(FizzBuzzConstants.INTEGER_STRING), new Integer(10));

    }

    @Test
    public void testRangeAndReportBadRange() {
        Throwable exception = assertThrows(Exception.class, () -> fizzBuzzService.doFizzBuzz(badLowerRange, badUpperRangeInteger));
        assertEquals(FizzBuzzConstants.INVALID_RANGE_EXCEPTION, exception.getMessage());

        exception = assertThrows(Exception.class, () -> fizzBuzzService.doFizzBuzz(badUpperRange, badUpperRange));
        assertEquals("For input string: \"badString\"", exception.getMessage());
    }

    @Test
    public void test() {
       when().get(localHost).then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void integrationTestFizzBuzzEndpointGoodInput() {
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put(lowerBound, "1");
            requestParams.put(upperBound, "20");
            given().contentType(MediaType.APPLICATION_JSON.toString())
                    .body(requestParams.toString()).post(localHost + FizzBuzzConstants.FIZZ_BUZZ_ENDPOINT)
                    .then()
                    .statusCode(HttpStatus.OK.value()).log().all();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void integrationTestFizzBuzzEndpointWorking() {
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put(lowerBound, "1");
            requestParams.put(upperBound, badUpperRange);
            given().contentType(MediaType.APPLICATION_JSON.toString())
                    .body(requestParams.toString()).post(localHost + FizzBuzzConstants.FIZZ_BUZZ_ENDPOINT)
                    .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value()).log().all();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
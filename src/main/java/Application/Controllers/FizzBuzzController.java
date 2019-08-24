package Application.Controllers;

import Application.EntitiesDto.FizzBuzzOutput;
import Application.EntitiesDto.FizzBuzzRequest;
import Application.Services.FizzBuzzService;
import Application.UtilConstants.FizzBuzzConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @PostMapping(value = FizzBuzzConstants.FIZZ_BUZZ_ENDPOINT)
    public ResponseEntity doFizzBuzz(@RequestBody FizzBuzzRequest fizzBuzzRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        FizzBuzzOutput output;
        try {
            output = fizzBuzzService.doFizzBuzz(fizzBuzzRequest.getLowerBound(), fizzBuzzRequest.getUpperBound());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(output, headers, HttpStatus.OK);
    }
}

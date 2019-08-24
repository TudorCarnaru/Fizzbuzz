import Application.Controllers.FizzBuzzController;
import Application.Main;
import Application.Services.FizzBuzzService;
import Application.UtilConstants.FizzBuzzConstants;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class FizzBuzzIntegrationTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new FizzBuzzController(new FizzBuzzService())).build();
    }


    private String lowerBound = "lowerBound";
    private String upperBound = "upperBound";
    private String localHost = "localhost:8080/";


    private String badLowerRange= "-1";
    private String badUpperRange = "badString";

    @Test
    public void test() throws Exception{
        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put(lowerBound, badLowerRange);
            requestParams.put(upperBound, badUpperRange);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mockMvc.perform(post(localHost + FizzBuzzConstants.FIZZ_BUZZ_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .header("host", "localhost:80")
                .content(requestParams.toString()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest());
    }

}

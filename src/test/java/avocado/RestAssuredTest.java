package avocado;

import com.cegeka.switchfully.security.Application;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
public abstract class RestAssuredTest {

    RequestSpecification givenRequestForUser(String username, String password) {
        String encodedString = Base64.getEncoder().encodeToString((username+":"+password).getBytes());
        return given()
                .header("Authorization", "Basic " + encodedString)
                .baseUri("http://localhost")
                .port(8080);
    }
}

package avocado;

import com.cegeka.switchfully.security.rest.ArmyResource;
import org.junit.Test;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class ElmTest extends RestAssuredTest {

    @Test
    public void promote_GivenCandidateHasCriminalRecord_ThenOk() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "JMILLER"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void promote_GivenCandidateHasCriminalRecord_ThenNotOk() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "CRIMI"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

}

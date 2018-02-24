package avocado;

import org.junit.Test;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class ElmTest extends RestAssuredTest {

    @Test
    public void promote_GivenCandidateHasCriminalRecord_ThenOk() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post("/army/promote/JMILLER")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void promote_GivenCandidateHasCriminalRecord_ThenNotOk() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post("/army/promote/CRIMI")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

}

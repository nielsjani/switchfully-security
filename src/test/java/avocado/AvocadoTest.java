package avocado;

import com.cegeka.switchfully.security.rest.ArmyInfoDto;
import com.cegeka.switchfully.security.rest.ArmyResource;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class AvocadoTest extends RestAssuredTest {

    @Test
    public void getDeployedArmyInfo_givenKnownUsernameAndPasswordEncodedAsBasicAuthenticationHeader_thenShouldAllowAccess() {
        ArmyInfoDto actual = givenRequestForUser("curie", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(OK.value())
                .extract()
                .body()
                .as(ArmyInfoDto.class);

        assertThat(actual.country).isEqualTo("Belgium");
    }

    @Test
    public void getDeployedArmyInfo_givenKnownUsernameAndWrongPasswordEncodedAsBasicAuthenticationHeader_thenShouldNotAllowAccess() {
        givenRequestForUser("curie", "wasspord")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUnknownUsernameAndPasswordEncodedAsBasicAuthenticationHeader_thenShouldNotAllowAccess() {
        givenRequestForUser("marie", "marie")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }
}

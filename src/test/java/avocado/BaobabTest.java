package avocado;

import com.cegeka.switchfully.security.rest.ArmyResource;
import org.junit.Test;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;

public class BaobabTest extends RestAssuredTest {
    @Test
    public void getDeployedArmyInfo_givenUserWithRoleScientist_ThenShouldGetForbidden() {
        givenRequestForUser("newton", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleItalians_ThenShouldGetForbidden() {
        givenRequestForUser("tesla", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleChemist_ThenShouldGetResult() {
        givenRequestForUser("curie", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleMathematist_ThenShouldGetResult() {
        givenRequestForUser("euler", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }




    @Test
    public void launchNukes_givenUserWithRoleScientist_ThenShouldGetForbidden() {
        givenRequestForUser("newton", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleItalians_ThenShouldGetForbidden() {
        givenRequestForUser("tesla", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleChemist_ThenShouldGetForbidden() {
        givenRequestForUser("curie", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleMathematist_ThenShouldGetResult() {
        givenRequestForUser("euler", "password")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }




    @Test
    public void joinArmy_givenUserWithRoleScientist_ThenShouldGetResult() {
        givenRequestForUser("newton", "password")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleItalians_ThenShouldGetForbidden() {
        givenRequestForUser("tesla", "password")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleChemist_ThenShouldGetForbidden() {
        givenRequestForUser("curie", "password")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleMathematist_ThenShouldGetForbidden() {
        givenRequestForUser("euler", "password")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }




    @Test
    public void promotePrivate_givenUserWithRoleScientist_ThenShouldGetForbidden() {
        givenRequestForUser("newton", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleItalians_ThenShouldGetResult() {
        givenRequestForUser("tesla", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleChemist_ThenShouldGetForbidden() {
        givenRequestForUser("curie", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleMathematist_ThenShouldGetForbidden() {
        givenRequestForUser("euler", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }




    @Test
    public void dischargePrivate_givenUserWithRoleScientist_ThenShouldGetForbidden() {
        givenRequestForUser("newton", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleItalians_ThenShouldGetResult() {
        givenRequestForUser("tesla", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleChemist_ThenShouldGetForbidden() {
        givenRequestForUser("curie", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleMathematist_ThenShouldGetForbidden() {
        givenRequestForUser("euler", "password")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }
}

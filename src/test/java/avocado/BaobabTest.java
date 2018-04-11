package avocado;

import com.cegeka.switchfully.security.ArmyResource;
import org.junit.Test;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;

public class BaobabTest extends RestAssuredTest {
    @Test
    public void getDeployedArmyInfo_givenUserWithRoleCivilian_ThenShouldGetForbidden() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleHumanRelations_ThenShouldGetForbidden() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRolePrivate_ThenShouldGetResult() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleGeneral_ThenShouldGetResult() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "Belgium"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }




    @Test
    public void launchNukes_givenUserWithRoleCivilian_ThenShouldGetForbidden() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleHumanRelations_ThenShouldGetForbidden() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void launchNukes_givenUserWithRolePrivate_ThenShouldGetForbidden() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleGeneral_ThenShouldGetResult() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .get(String.format("%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "nuke"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }




    @Test
    public void joinArmy_givenUserWithRoleCivilian_ThenShouldGetResult() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleHumanRelations_ThenShouldGetForbidden() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void joinArmy_givenUserWithRolePrivate_ThenShouldGetForbidden() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleGeneral_ThenShouldGetForbidden() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .post(ArmyResource.ARMY_RESOURCE_PATH)
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }




    @Test
    public void promotePrivate_givenUserWithRoleCivilian_ThenShouldGetForbidden() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleHumanRelations_ThenShouldGetResult() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void promotePrivate_givenUserWithRolePrivate_ThenShouldGetForbidden() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleGeneral_ThenShouldGetForbidden() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "promote", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }




    @Test
    public void dischargePrivate_givenUserWithRoleCivilian_ThenShouldGetForbidden() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleHumanRelations_ThenShouldGetResult() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRolePrivate_ThenShouldGetForbidden() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleGeneral_ThenShouldGetForbidden() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .post(String.format("%s/%s/%s", ArmyResource.ARMY_RESOURCE_PATH, "discharge", "ZWANETTA"))
                .then()
                .assertThat()
                .statusCode(FORBIDDEN.value());
    }
}

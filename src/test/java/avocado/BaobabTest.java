package avocado;

import org.junit.Test;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class BaobabTest extends RestAssuredTest {

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleCivilian_ThenShouldGetUnauthorised() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .get("/army/Belgium")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleHumanRelations_ThenShouldGetUnauthorised() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .get("/army/Belgium")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRolePrivate_ThenShouldGetResult() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .get("/army/Belgium")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void getDeployedArmyInfo_givenUserWithRoleGeneral_ThenShouldGetResult() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .get("/army/Belgium")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }




    @Test
    public void launchNukes_givenUserWithRoleCivilian_ThenShouldGetUnauthorised() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .get("/army/nuke")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleHumanRelations_ThenShouldGetUnauthorised() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .get("/army/nuke")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void launchNukes_givenUserWithRolePrivate_ThenShouldGetUnauthorised() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .get("/army/nuke")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void launchNukes_givenUserWithRoleGeneral_ThenShouldGetResult() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .get("/army/nuke")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }




    @Test
    public void joinArmy_givenUserWithRoleCivilian_ThenShouldGetResult() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .post("/army")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleHumanRelations_ThenShouldGetUnauthorised() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post("/army")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void joinArmy_givenUserWithRolePrivate_ThenShouldGetUnauthorised() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .post("/army")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void joinArmy_givenUserWithRoleGeneral_ThenShouldGetUnauthorised() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .post("/army")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }




    @Test
    public void promotePrivate_givenUserWithRoleCivilian_ThenShouldGetUnauthorised() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .post("/army/promote/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleHumanRelations_ThenShouldGetResult() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post("/army/promote/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void promotePrivate_givenUserWithRolePrivate_ThenShouldGetUnauthorised() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .post("/army/promote/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void promotePrivate_givenUserWithRoleGeneral_ThenShouldGetUnauthorised() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .post("/army/promote/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }




    @Test
    public void dischargePrivate_givenUserWithRoleCivilian_ThenShouldGetUnauthorised() {
        givenRequestForUser("ZWANETTA", "WORST")
                .when()
                .post("/army/discharge/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleHumanRelations_ThenShouldGetResult() {
        givenRequestForUser("UNCLE", "SAM")
                .when()
                .post("/army/discharge/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(OK.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRolePrivate_ThenShouldGetUnauthorised() {
        givenRequestForUser("JMILLER", "THANKS")
                .when()
                .post("/army/discharge/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }

    @Test
    public void dischargePrivate_givenUserWithRoleGeneral_ThenShouldGetUnauthorised() {
        givenRequestForUser("GENNY", "RALLY")
                .when()
                .post("/army/discharge/ZWANETTA")
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED.value());
    }
}

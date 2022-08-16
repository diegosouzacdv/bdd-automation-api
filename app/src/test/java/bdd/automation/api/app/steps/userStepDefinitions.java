package bdd.automation.api.app.steps;

import io.cucumber.docstring.DocString;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class userStepDefinitions {

    private Map<String, String> expectedUser = new HashMap<>();

    @Quando("faco um POST para {word} com os seguintes valores:")
    public void facoUmPOSTParaVUserComOsSeguintesValores(String endpoint, Map<String, String> user) {

        expectedUser = user;

        given()
                .body(user)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Entao("quando faco um GET para {word}, o usuario criado e retornado")
    public void quandoFacoUmGETParaVUserRafaelOUsuarioCriadoERetornado(String endpoint) {
        when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("username", is(expectedUser.get("username")));
    }

    @Quando("eu faco um POST para {word} com a seguinte docString:")
    public void euFacoUmPOSTParaVUserComASeguinteDocString(String endpoint, DocString docString) {

        expectedUser.put("username", "theUser");

        given()
                .body(docString.getContent())
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}

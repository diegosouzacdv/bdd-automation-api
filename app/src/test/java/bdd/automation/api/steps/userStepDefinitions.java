package bdd.automation.api.steps;

import bdd.automation.api.support.api.UserApi;
import bdd.automation.api.support.domain.User;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class userStepDefinitions {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";
    private User expectedUser;
    UserApi userApi = new UserApi();

//    public userStepDefinitions(UserApi userApi) {
//        this.userApi = userApi;
//    }


    @Quando("crio um usuario")
    public void crioUmUsuario() {
        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);
    }

    @Entao("o usuario e salvo no sistema")
    public void oUsuarioESalvoNoSistema() {
        String actualUserName = userApi.getUserName(expectedUser);
        assertThat(actualUserName, is(expectedUser.getUsername()));
    }
}

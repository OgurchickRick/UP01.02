package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.RequestModel.JobRequest;
import model.RequestModel.LoginRequest;
import model.ResponseModel.*;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    @Step("Получить список пользователей")
    public UserListResponse getUserList(Integer id){
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users?page=" + id)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response().as(UserListResponse.class);
    }

    @Step("Получить пользователя по ID")
    public UserResponse getUserById(Integer id, Integer statusCode){
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users/" + id)
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(UserResponse.class);
    }

    @Step("Поверка ответа")
    public void checkResponse(UserResponse userExcepted, UserResponse userActual){
        Assert.assertEquals(userExcepted, userActual);
    }

    @Step("Создать пользователя")
    public JobResponse createUser(JobRequest job){
        return given()
                .baseUri("https://reqres.in")
                .body(job)
                .contentType(ContentType.JSON)
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract()
                .response().body().as(JobResponse.class);
    }

    @Step("Получить список ресурсов")
    public ResourceListResponse getResourceList(){
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .extract()
                .response().body().as(ResourceListResponse.class);
    }

    @Step("Получить ресурс по ID")
    public ResourceResponse getResourceById(Integer id, Integer statusCode){
        return given()
                .baseUri("https://reqres.in")
                .get("/api/unknown/" + id)
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(ResourceResponse.class);
    }

    @Step("Изменить пользователя")
    public JobResponse putUpdateUser(JobRequest job, Integer id){
        return given()
                .baseUri("https://reqres.in")
                .body(job)
                .contentType(ContentType.JSON)
                .put("/api/users/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response().body().as(JobResponse.class);
    }

    @Step("Изменить пользователя")
    public JobResponse patchUpdateUser(JobRequest job, Integer id){
        return given()
                .baseUri("https://reqres.in")
                .body(job)
                .contentType(ContentType.JSON)
                .patch("/api/users/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response().body().as(JobResponse.class);
    }

    @Step("Удалить пользователя")
    public void deleteUser(Integer id){
         given()
                .baseUri("https://reqres.in")
                .delete("/api/users/" + id)
                .then()
                .statusCode(204);
    }

    @Step("Регистрация пользователя")
    public Response registration(LoginRequest body, Integer statusCode){
        return given()
                .baseUri("https://reqres.in")
                .body(body)
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();

    }

    @Step("Авторизация пользователя")
    public Response login(LoginRequest body, Integer statusCode){
        return given()
                .baseUri("https://reqres.in")
                .body(body)
                .contentType(ContentType.JSON)
                .post("/api/login")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    @Step("Получить список пользователей")
    public UserListResponse getUserListDelay(Integer id){
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users?delay=" + id)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response().as(UserListResponse.class);
    }
}

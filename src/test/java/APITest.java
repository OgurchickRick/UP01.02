import io.qameta.allure.Epic;
import model.RequestModel.JobRequest;
import model.RequestModel.LoginRequest;
import model.ResponseModel.*;
import org.testng.annotations.Test;

@Epic("Тесты reqres")
public class APITest extends BaseTest {
    @Test(description = "Получить список пользователей")
    public void getAllUsers(){
        System.out.println(API_STEPS.getUserList(2));
    }

    @Test(description = "Получить пользователя по ID")
    public void getUserById(){
        UserResponse userEx = new UserResponse(new DataUserResponse(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"), new SupportResponse("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!"));

        UserResponse user = API_STEPS.getUserById(2, 200);
        API_STEPS.checkResponse(user, userEx);
        System.out.println(user);
    }

    @Test(description = "Создать пользователя")
    public void createUser(){
        JobRequest jobRequest = new JobRequest("Morpheus", "leader");
        JobResponse job = API_STEPS.createUser(jobRequest);
        System.out.println(job);
    }

    @Test(description = "Получить несуществующего пользователя по ID")
    public void getNotFoundUser(){
        UserResponse userEx = new UserResponse(null, null);
        UserResponse user = API_STEPS.getUserById(23, 404);
        API_STEPS.checkResponse(userEx, user);
        System.out.println(user);
    }

    @Test(description = "Получить список ресурсов")
    public void getListResource(){
        System.out.println(API_STEPS.getResourceList());
    }

    @Test(description = "Получить ресурс по ID")
    public void getResourceById(){
        System.out.println(API_STEPS.getResourceById(2, 200));
    }

    @Test(description = "Получить несуществующий ресурс по ID")
    public void getNotFoundResource(){
        System.out.println(API_STEPS.getResourceById(655, 404));
    }

    @Test(description = "Изменить пользователя")
    public void putUpdateUser(){
        JobRequest jobRequest = new JobRequest("Morpheus", "leader");

        System.out.println(API_STEPS.putUpdateUser(jobRequest, 2));
    }

    @Test(description = "Изменить пользователя")
    public void patchUpdateUser(){
        JobRequest jobRequest = new JobRequest("Morpheus", "leader");

        System.out.println(API_STEPS.putUpdateUser(jobRequest, 2));
    }

    @Test(description = "Удалить пользователя")
    public void deleteUser(){
        API_STEPS.deleteUser(2);
    }

    @Test(description = "Зарегистрировать пользователя - успешно")
    public void registration(){
        LoginRequest body = new LoginRequest("eve.holt@reqres.in", "pistol");
        System.out.println(API_STEPS.registration(body, 200).body().as(RegistrResponse.class));
    }

    @Test(description = "Зарегистрировать пользователя - не очень успешно")
    public void registrationFail(){
        LoginRequest body = new LoginRequest("eve.holt@reqres.in", null);
        System.out.println(API_STEPS.registration(body, 400).body().asString());
    }

    @Test(description = "Авторизация пользователя - успешно")
    public void login(){
        LoginRequest body = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        System.out.println(API_STEPS.login(body, 200).body().as(LoginResponse.class));
    }

    @Test(description = "Авторизация пользователя - успешно")
    public void loginFail(){
        LoginRequest body = new LoginRequest("eve.holt@reqres.in", null);
        System.out.println(API_STEPS.login(body, 400).body().asString());
    }

    @Test(description = "Получить список пользователей")
    public void getAllUsersDelay(){
        System.out.println(API_STEPS.getUserList(3));
    }
}

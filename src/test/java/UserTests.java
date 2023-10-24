import helpers.Utils;
import io.qameta.allure.Epic;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Тесты пользователя")
public class UserTests extends BaseTest{

    User user;

    @BeforeMethod
    public void genUser(){
        user = User.builder()
                .firstName(Utils.genFirstName())
                .lastName((Utils.genLastName()))
                .phone(Utils.genPhone())
                .address(Utils.genAddress())
                .gender(Utils.genGender())
                .password(Utils.genPassword(10))
                .build();
    }

    @Test(description = "Проверка почты на валидность")
    public void checkValidEmail(){
        USER_STEP.checkSobaka(user.getEmail());
        USER_STEP.checkTochka(user.getEmail());
        USER_STEP.checkSapret(user.getEmail());
    }

    @Test(description = "Проверка номера на валидность")
    public void checkValidPhone(){
        USER_STEP.checkShablon(user.getPhone());
        USER_STEP.checkLengthNumber(user.getPhone());
        USER_STEP.checkNumberFromRussia(user.getPhone());
    }

    @Test(description = "Проверка пароля на валидность")
    public void checkValidPassword(){
        USER_STEP.checkDigit(user.getPassword());
        USER_STEP.checkLengthPass(user.getPassword());
        USER_STEP.checkSpecialSim(user.getPassword());
    }

}

package steps;

import io.qameta.allure.Step;
import org.testng.Assert;

public class UserStep {

    @Step("Проверить, что почта содержит @")
    public void checkSobaka(String email){
        Assert.assertTrue(email.contains("@"));
    }

    @Step("Проверить, что почта содержит .")
    public void checkTochka(String email){
        Assert.assertTrue(email.contains("."));
    }

    @Step("Проверить, что почта не содержит запрещённых символов")
    public void checkSapret(String email){
        Assert.assertTrue(email.matches("^[a-zA-Z0-9@\\-_.]*$"));
    }

    @Step("Проверить, что номер правильной длины")
    public void checkLengthNumber(String phone){
        Assert.assertEquals(phone.replaceAll("[^0-9]", "").length(), 11);
    }

    @Step("Проверить, что номер русский")
    public void checkNumberFromRussia(String phone){
        Assert.assertTrue(phone.startsWith("+7"));
    }

    @Step("Проверить, что номер соответствует шаблону +Х(ХХХ)ХХХ-ХХ-ХХ")
    public void checkShablon(String phone){
        Assert.assertTrue(phone.matches("^\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$"));
    }

    @Step("Проверить, что пароль допустимой длины")
    public void checkLengthPass(String password){
        Assert.assertTrue(password.length() >= 8);
    }

    @Step("Проверить, что пароль содержит цифры")
    public void checkDigit(String password){
        Assert.assertTrue(password.chars().anyMatch(Character::isDigit));
    }

    @Step("Проверить, что пароль содержит спец символы")
    public void checkSpecialSim(String password){
        Assert.assertTrue(password.matches(".*[!@#$%^&*()\\-+=<>?].*"));
    }
}

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import model.RequestModel.JobRequest;
import model.ResponseModel.DataUserResponse;
import model.ResponseModel.JobResponse;
import model.ResponseModel.SupportResponse;
import model.ResponseModel.UserResponse;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Группа 1")
@Feature("Подгруппа 2")
public class Ex extends BaseTest{

    @BeforeClass
    public void bfC(){}

    @BeforeMethod
    public void bfM(){}

    @Test(testName = "Первый тест", description = "Первый тест")
    public void testOne(){
        step1(1);
        step2("gdjfg");
    }

    @Test(testName = "Второй тест", description = "Второй тест")
    @Description("Второй тест")
    public void testTwo(){
        Assert.assertEquals(1, 1);
        Assert.assertEquals(1, 1);
    }

    @Step("Проверка числа")
    public void step1(int checkNum){
        Assert.assertEquals(1, checkNum);
    }

    @Step("Проверка строки")
    public void step2(String checkStr){
        Assert.assertEquals(1, checkStr);
    }

    @AfterClass
    public void afterC(){}

    @AfterMethod
    public void afterM(){}

}

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Домашка")
@Feature("ДЗ 1")
public class TestsDesc {
    @Test(testName = "RichBitch", description = "Тест 1")
    @Description("Тест 1")
    public void testDisc1(){
        Assert.assertEquals((int) Main.disc(1, 5, 6), 1);
    }

    @Test(testName = "RichBitch2", description = "Тест 2")
    @Description("Тест 2")
    public void testDisc2(){
        Assert.assertEquals((int) Main.disc(1, -6, 9), 0);
    }

    @Test(testName = "RichBitch3", description = "Тест 3")
    @Description("Тест 3")
    public void testDisc3(){
        Assert.assertEquals((int) Main.disc(2, 2, 2), -12);
    }
}

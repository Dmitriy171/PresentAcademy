import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class CreateAccount {
    SelenideElement btnSignIn = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]"));
    SelenideElement inputFieldEmail = $("#email_create");
    SelenideElement btnCreate = $(By.xpath("//form[@id='create-account_form']//span[1]"));
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    int randomInt2 = randomGenerator.nextInt(2) + 1;
    String username = RandomStringUtils.randomAlphabetic(12);
    //    emailTextBx.sendKeys("username"+ randomInt +"@gmail.com");


    public CreateAccount signInPage() {
        $(btnSignIn).click();
        assertEquals(Selenide.title(), "Login - My Store");
        return this;
    }

    public CreateAccount inputEmail() {
        $(inputFieldEmail).setValue(username + "@gmail.com");
        $(btnCreate).click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/h3[1]")).getText().contains("Your personal information");
        return this;
    }

    public CreateAccount data() {
        $(By.id("id_gender" + (randomInt2) + "")).click();
        $("#customer_firstname").setValue(username);
        $("#customer_lastname").setValue(username + "Last");
        $("#passwd").setValue(username);
        $("#days").selectOptionByValue("25");
        $("#months").selectOptionByValue("5");
        $("#years").selectOptionByValue("1989");
        $("#firstname").setValue(username);
        $("#lastname").setValue(username + "Last");
        $("#address1").setValue(randomInt + " street");
        $("#city").setValue("Juneau");
        $("#id_state").selectOptionByValue("2");
        $("#postcode").setValue("21547");
        $("#other").setValue("I love fashionable things");
        $("#phone").setValue("0325874126598");
        $("#phone_mobile").setValue("165465487842");
        $("#alias").setValue("My address");
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[4]/button[1]/span[1]")).click();
        return this;
    }

    public CreateAccount checkTitleData(){
        assertEquals(Selenide.title(), "My account - My Store");
        return this;
    }


}
